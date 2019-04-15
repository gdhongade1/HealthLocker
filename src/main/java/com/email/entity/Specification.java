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
@Table(name="Specification")
public class Specification {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="specificationId")
	private long specificationId; 
	
	@Column(name="name")
	private String name; 		
	
	@Column(name="descrition")
	private String descrition;
	

	@ManyToOne
    @JoinColumn
    @JsonIgnore
	private ApprovedEmail appEmail;
	
	public Specification() {
	}

	public long getSpecificationId() {
		return specificationId;
	}

	public void setSpecificationId(long specificationId) {
		this.specificationId = specificationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescrition() {
		return descrition;
	}

	public void setDescrition(String descrition) {
		this.descrition = descrition;
	}

}
