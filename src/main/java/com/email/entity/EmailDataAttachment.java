package com.email.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EmailData_Attachment")
public class EmailDataAttachment {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="edId")
	private long  edId;
	
	@Column(name="emailData_Id")
	private long  emailData_Id;
	
	@Column(name="fileId")
	private long fileId;
	

	public EmailDataAttachment() {
		super();
	}

	public long getEdId() {
		return edId;
	}

	public void setEdId(long edId) {
		this.edId = edId;
	}


	public long getEmailData_Id() {
		return emailData_Id;
	}

	public void setEmailData_Id(long emailData_Id) {
		this.emailData_Id = emailData_Id;
	}

	public long getFileId() {
		return fileId;
	}

	public void setFileId(long fileId) {
		this.fileId = fileId;
	}
	
	
	

}
