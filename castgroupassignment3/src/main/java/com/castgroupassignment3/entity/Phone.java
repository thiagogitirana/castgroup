package com.castgroupassignment3.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Entidade rsponsável por armazenar os dados de telefone da pessoa
 * 
 * @author Thiago Gitirana
 *
 */
@Entity
public class Phone {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "phone_id")
	private Long id;

	@JsonProperty("cellPhone")
	private Long cellPhone;

	@JsonProperty("phone")
	private Long phone;

	@ManyToOne
	@JoinColumn(name = "person_id")
	@JsonBackReference
	private Person person;

	public Phone(Long id, Long cellPhone, Long phone, Person person) {
		super();
		this.id = id;
		this.cellPhone = cellPhone;
		this.phone = phone;
		this.person = person;
	}

	public Phone() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(Long cellPhone) {
		this.cellPhone = cellPhone;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
