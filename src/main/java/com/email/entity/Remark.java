package com.email.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Remark")
public class Remark {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="remarkId")
	private long remarkId; 
	
	@Column(name="name")
	private String name; 	
	
	@Column(name="descrition")
	private String descrition;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "remark")
	@JsonIgnore
	private List<ApprovedEmail> appEmail;
	
	public Remark() {
	}

	public List<ApprovedEmail> getAppEmail() {
		return appEmail;
	}

	public void setAppEmail(List<ApprovedEmail> appEmail) {
		this.appEmail = appEmail;
	}


	public long getRemarkId() {
		return remarkId;
	}

	public void setRemarkId(long remarkId) {
		this.remarkId = remarkId;
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
