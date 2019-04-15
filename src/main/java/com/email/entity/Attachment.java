package com.email.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Attachment")
public class Attachment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="fileId")
	private long fileId; 
	
	@Column(name="fileType")
	private String fileType;
	
	@Column(name="fileSize")
	private long fileSize;
	
	@Column(name="filePath")
	private String filePath;
	
	@Column(name="user_id")
	private long user_id; 
	
	@Column(name="email_Id")
	private long email_Id;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "attachment")
	@JsonIgnore
	private List<ApprovedEmail> appEmail;
	

	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "attachment")
	@JsonIgnore
	private List<EmailData> emailData;
	
	public List<EmailData> getEmailData() {
		return emailData;
	}


	public void setEmailData(List<EmailData> emailData) {
		this.emailData = emailData;
	}


	public Attachment() {
	}


	public long getFileId() {
		return fileId;
	}


	public void setFileId(long fileId) {
		this.fileId = fileId;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public long getEmail_Id() {
		return email_Id;
	}

	public void setEmail_Id(long email_Id) {
		this.email_Id = email_Id;
	}





	public List<ApprovedEmail> getAppEmail() {
		return appEmail;
	}




	public void setAppEmail(List<ApprovedEmail> appEmail) {
		this.appEmail = appEmail;
	}



	

}
