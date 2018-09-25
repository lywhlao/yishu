/**
 * @(#)MapperAspect, 2015年6月15日.
 * <p>
 * Copyright 2015 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.yishu.server.aop;

import com.alibaba.fastjson.JSON;
import com.yishu.server.exception.custom.BizException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.Map;

/**
 * 统一记录用户操作日志
 *
 * @author hzxulianzhen
 */
@Component
@Aspect
public class InteractAspect {

    private static final Logger logger = LoggerFactory.getLogger(InteractAspect.class);

    /**
     * 针对所有的Mapped
     */
    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void mapperPointcut() {
    }

    /**
     * 记录操作行为
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("mapperPointcut()")
    public Object mapperAround(ProceedingJoinPoint joinPoint) throws Throwable {

        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        String url = request.getRequestURI();
        Map param = request.getParameterMap();
        try {
            // result的值就是被拦截方法的返回值
            Object result = joinPoint.proceed();
            String resultJson= JSON.toJSONString(result);
            if(resultJson.contains("\"code\":200")){
               if(resultJson.length()>100){
                   resultJson="success default content";
               }
            }
            logger.info("url='{}',requestParam='{}',response='{}',ip={}",
                        url, JSON.toJSONString(param), resultJson);
            return result;
        } catch (Throwable e) {

            // 抛出的异常会通过封装成UndeclaredThrowableException，需要取出原来的异常
            if (e instanceof UndeclaredThrowableException) {
                e = ((UndeclaredThrowableException) e).getUndeclaredThrowable();
            }
            // 通用逻辑异常
            if (e instanceof BizException) {
                BizException be = (BizException) e;
                logger.info("url='{}',request='{}',response='{code:{},msg:{},content:{}}'",
                            url,JSON.toJSONString(param), be.getCode(), be.getMsg(), be.getContent());
            }
            // 其它异常
            else {
                logger.info("url='{}',request='{}',response='{exp:{},message:{}}',detail:{}",
                            url, JSON.toJSONString(param), e.getClass().getName(), e.getMessage(), e.getStackTrace());
            }
            throw e;
        }
    }

}
