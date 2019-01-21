package com.castgroupassignment1.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 * Entidade responsável por armazenar os dados base64 left e right
 * 
 * @author Thiago Gitirana
 *
 */
@Entity
public class DataEntity {

	@Id
	private Long id;

	@Lob
	private String leftData;

	@Lob
	private String rightData;

	public DataEntity() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLeftData() {
		return leftData;
	}

	public void setLeftData(String leftData) {
		this.leftData = leftData;
	}

	public String getRightData() {
		return rightData;
	}

	public void setRightData(String rightData) {
		this.rightData = rightData;
	}

}
