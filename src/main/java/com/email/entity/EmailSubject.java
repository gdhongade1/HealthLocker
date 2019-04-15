package com.email.entity;

import java.io.Serializable;

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
@Table(name="Email_Subject")
public class EmailSubject implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="esId")
	private long esId;
	
	@Column(name="appEmailId")
	private long appEmailId;
	
	@Column(name="subjectId")
	private long subjectId;
	

	public EmailSubject() {
	}


	public long getEsId() {
		return esId;
	}

	public void setEsId(long esId) {
		this.esId = esId;
	}


	public long getAppEmailId() {
		return appEmailId;
	}

	public void setAppEmailId(long appEmailId) {
		this.appEmailId = appEmailId;
	}

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}
	
	
}
