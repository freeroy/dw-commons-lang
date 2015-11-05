package org.developerworld.commons.lang;


/**
 * 操作异常类
 * 
 * @author Roy Huang
 * @version 20110424
 * @deprecated 不在建议使用特殊异常
 */
public class OperationException extends Exception {

	public OperationException() {
		super();
	}

	public OperationException(String msg) {
		super(msg);
	}

	public OperationException(String message, Throwable cause) {
		super(message, cause);
	}

	public OperationException(Throwable cause) {
		super(cause);
	}

}
