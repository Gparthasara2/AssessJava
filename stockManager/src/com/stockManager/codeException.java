package com.stockManager;

public class codeException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;

	public String getMsg() {
		return msg;
	}

	public codeException(String msg) {
		this.msg = msg;
	}
}
