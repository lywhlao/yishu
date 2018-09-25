package com.yishu.server.exception.custom;

/**
 * DB异常
 * 
 * @author hzxulianzhen
 */
public class DBException extends CustomException {

	private static final long serialVersionUID = 1L;

	public DBException() {
		super();
	}

	public DBException(String msg) {
		super(msg);
	}

	public DBException(Throwable t) {
		super(t);
	}

	public DBException(String msg, Throwable t) {
		super(msg, t);
	}
}
