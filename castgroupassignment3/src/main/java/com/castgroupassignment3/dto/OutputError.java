package com.castgroupassignment3.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Classe responsável por mapear o retorno de erros
 * 
 * @author Thiago Gitirana
 *
 */
public class OutputError {
	@JsonProperty("message")
	private String message;

	@JsonProperty("errorCode")
	private Integer errorCode;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

}
