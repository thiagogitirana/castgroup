package com.castgroupassignment1.exception;

/**
 * Classe responsável pelo tratamento das exceções de negócio
 * 
 * @author Thiago Gitirana
 *
 */
public class BusinessException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7705825677170617641L;

	private String message;
	private int code;

	public BusinessException(String message, int code) {
		super();
		this.message = message;
		this.code = code;
	}

	public BusinessException() {
		super();

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
