package com.yishu.server.configure;

import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfigure {


    /**
     * 配置Jedis链接
     * @return
     */
    @Bean
    public RedisTemplate<Object,Object> redisTemplate(JedisConnectionFactory jedisConnectionFactory) {
        RedisTemplate<Object,Object> redisTemplate = new RedisTemplate<Object,Object>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
//        可自定义序列化
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new GenericFastJsonRedisSerializer());
        redisTemplate.setValueSerializer(new GenericFastJsonRedisSerializer());
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }



}
