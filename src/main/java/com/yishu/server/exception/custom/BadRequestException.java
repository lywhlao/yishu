package com.yishu.server.exception.custom;


import com.yishu.server.model.constant.RetCode;

/**
 * 参数异常
 *
 * Created by hzxulianzhen on 2016/11/3.
 */
public class BadRequestException extends RuntimeException {

	/**
	 * 异常码
	 */
	private int code;

	/**
	 * 异常信息
	 */
	private String msg;

	private Object content;

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

	public BadRequestException() {

	}

	public BadRequestException(String message) {
		super(message);
		this.msg = message;
	}

	public BadRequestException(int logicCode, String message) {
		super(message);
		this.code = logicCode;
		this.msg = message;
	}

	public BadRequestException(RetCode retCode) {
		super();
		this.code = retCode.code;
		this.msg = retCode.msg;
	}

	public BadRequestException(RetCode retCode,Object content) {
		super();
		this.code = retCode.code;
		this.msg = retCode.msg;
		this.content=content;
	}

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
}
