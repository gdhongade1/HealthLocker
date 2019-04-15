package com.email.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Email_Specification")
public class EmailSpecification {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="esId")
	private long esId;
	
	@Column(name="appEmailId")
	private long appEmailId;
	
	@Column(name="specificationId")
	private long specificationId;
	

	@ManyToOne
    @JoinColumn
    @JsonIgnore
	private ApprovedEmail appEmail;

	public EmailSpecification() {
	}

	public long getAppEmailId() {
		return appEmailId;
	}

	public void setAppEmailId(long appEmailId) {
		this.appEmailId = appEmailId;
	}

	public ApprovedEmail getAppEmail() {
		return appEmail;
	}

	public void setAppEmail(ApprovedEmail appEmail) {
		this.appEmail = appEmail;
	}

	public long getEsId() {
		return esId;
	}

	public void setEsId(long esId) {
		this.esId = esId;
	}


	public long getSpecificationId() {
		return specificationId;
	}

	public void setSpecificationId(long specificationId) {
		this.specificationId = specificationId;
	}
	
	
}
