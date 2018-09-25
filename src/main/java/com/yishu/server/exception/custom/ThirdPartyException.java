package com.yishu.server.exception.custom;

import com.yishu.server.model.constant.RetCode;
import lombok.Data;

/**
 * 第三方接口异常
 *
 */
@Data
public class ThirdPartyException extends CustomException {

	/**
	 * 异常码
	 */
	private int code;

	/**
	 * 异常信息
	 */
	private String msg;

	private Object content;


	public ThirdPartyException() {

	}

	public ThirdPartyException(String message) {
		super(message);
		this.msg = message;
	}

	public ThirdPartyException(int logicCode, String message) {
		super(message);
		this.code = logicCode;
		this.msg = message;
	}

	public ThirdPartyException(int logicCode, String message,Object content) {
		super(message);
		this.code = logicCode;
		this.msg = message;
		this.content=content;
	}

	public ThirdPartyException(RetCode retCode) {
		super();
		this.code = retCode.code;
		this.msg = retCode.msg;
	}

	public ThirdPartyException(RetCode retCode,Object content) {
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

	@Override
	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
