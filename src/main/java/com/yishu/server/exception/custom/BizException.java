package com.yishu.server.exception.custom;

import com.yishu.server.model.constant.RetCode;
import lombok.Data;

/**
 * 内部业务异常
 *
 * @author nanzihao
 */
@Data
public class BizException extends CustomException {

    private static final long serialVersionUID = -7294971020964842814L;

    private int code;

    private String msg;

    private Object content;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public BizException(int code, String msg) {
        this(code, msg, null);
    }

    public BizException(int code, String msg, Object content) {
        super(msg);
        this.code = code;
        this.msg = msg;
        this.content = content;
    }

    public BizException() {
        super("ERR.SYSTEM");
    }

    public BizException(RetCode retCode) {
        super();
        this.code = retCode.code;
        this.msg = retCode.msg;
    }

    public BizException(RetCode retCode, Object content) {
        this(retCode);
        this.content = content;
    }

    public BizException(String message) {
        super(message);
        this.code = RetCode.BAD_REQUEST.code;
        this.msg = RetCode.BAD_REQUEST.msg;
        this.content = message;
    }


}
