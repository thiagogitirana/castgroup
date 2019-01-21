package com.castgroupassignment1.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Classe responsável por mapear as requisições
 * 
 * @author Thiago Gitirana
 *
 */
public class DataDTO {

	@JsonIgnore
	private Long id;

	private String data;

	public DataDTO(Long id, String data) {
		super();
		this.id = id;
		this.data = data;
	}

	public DataDTO() {
		super();
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
