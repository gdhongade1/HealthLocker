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
@Table(name="Email_Remark")
public class EmailRemark {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="esId")
	private long erId;
	
	@Column(name="appEmailId")
	private long appEmailId;
	
	@Column(name="remarkId")
	private long remarkId;
	

	@ManyToOne
    @JoinColumn
    @JsonIgnore
	private ApprovedEmail appEmail;
	
	public EmailRemark() {
	}

	public ApprovedEmail getAppEmail() {
		return appEmail;
	}

	public void setAppEmail(ApprovedEmail appEmail) {
		this.appEmail = appEmail;
	}


	public long getErId() {
		return erId;
	}

	public void setErId(long erId) {
		this.erId = erId;
	}

	public long getAppEmailId() {
		return appEmailId;
	}

	public void setAppEmailId(long appEmailId) {
		this.appEmailId = appEmailId;
	}

	public long getRemarkId() {
		return remarkId;
	}

	public void setRemarkId(long remarkId) {
		this.remarkId = remarkId;
	}
	
}
