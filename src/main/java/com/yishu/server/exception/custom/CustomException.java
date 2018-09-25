package com.yishu.server.exception.custom;

import com.yishu.server.model.constant.RetCode;
import lombok.Data;

/**
 * Created by hzlaojiaqi on 2017/7/19.
 */
@Data
public class CustomException extends RuntimeException{

    public CustomException() {
    }

    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomException(Throwable cause) {
        super(cause);
    }

    public CustomException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public int getCode() {
        return RetCode.SERVER_BUSY.code;
    }

    public String getMsg() {
        return RetCode.SERVER_BUSY.msg;
    }

    public Object getContent() {
        return RetCode.SERVER_BUSY;
    }


}
