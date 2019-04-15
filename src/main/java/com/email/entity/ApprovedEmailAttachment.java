package com.email.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ApprovedEmail_Attachment")
public class ApprovedEmailAttachment {
	

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="apId")
	private long  apId;
	
	@Column(name="appEmailId")
	private long appEmailId;
	
	@Column(name="fileId")
	private long fileId;
	
	public ApprovedEmailAttachment() {}

	public long getApId() {
		return apId;
	}

	public void setApId(long apId) {
		this.apId = apId;
	}


	public long getAppEmailId() {
		return appEmailId;
	}

	public void setAppEmailId(long appEmailId) {
		this.appEmailId = appEmailId;
	}

	public long getFileId() {
		return fileId;
	}

	public void setFileId(long fileId) {
		this.fileId = fileId;
	}
	
	
}
