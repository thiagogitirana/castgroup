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
 * @author Thiago Gitirana
 *
 */
@Entity
public class Phone {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "phone_id")
	private long id;

	@JsonProperty("cellPhone")
	private long cellPhone;

	@JsonProperty("phone")
	private long phone;

	@ManyToOne
	@JoinColumn(name = "person_id")
	@JsonBackReference
	private Person person;

	public Phone(long cellPhone, long phone, Person person) {
		super();
		this.cellPhone = cellPhone;
		this.phone = phone;
		this.person = person;
	}

	public Phone() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(long cellPhone) {
		this.cellPhone = cellPhone;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
