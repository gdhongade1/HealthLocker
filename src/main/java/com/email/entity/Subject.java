package com.email.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.JoinColumn;

@Entity
@Table(name="Subject")
public class Subject {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="subjectId")
	private long subjectId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="descrition")
	private String descrition;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "sub")
	@JsonIgnore
	private List<ApprovedEmail> appEmail;
	

	public Subject() {
	}


	public List<ApprovedEmail> getAppEmail() {
		return appEmail;
	}


	public void setAppEmail(List<ApprovedEmail> appEmail) {
		this.appEmail = appEmail;
	}


	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
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
