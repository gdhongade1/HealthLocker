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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="EmailData")
public class EmailData {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="emailData_Id")
	private long emailData_Id;
	
	@Column(name="senderId")
	private String senderId; 	
	
	@Column(name="ccId")
	private String ccId;	
	
	@Column(name="toId")
	private String toId;	
	
	@Column(name="subject")
	private String subject;	
	
	@Column(name="body")
	private String body;	
	
	@Column(name="dateTime")
	private String dateTime; 	
	
	@Column(name="createdOn")
	private String createdOn; 
	
	@Column(name="updatedOn")
	private String updatedOn; 
	
	@Column(name="status")
	private String status;  
	
	@Column(name="user_id")
	private long user_id;
	
	 	@ManyToOne
	    @JoinColumn
	    @JsonIgnore
	    private UserRegistration userEmail;
	 	
	 	  @OneToOne(mappedBy = "emailData")
	 	 @JsonIgnore
		  private ApprovedEmail appEmail;
	 	  
	 	 @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
		  @JoinTable(name = "EmailData_Attachment",joinColumns = { @JoinColumn(name = "emailData_Id") },
		            							inverseJoinColumns = { @JoinColumn(name = "fileId") })
		 private List<Attachment> attachment;
	 	  

	public List<Attachment> getAttachment() {
			return attachment;
		}


		public void setAttachment(List<Attachment> attachment) {
			this.attachment = attachment;
		}


	public EmailData() {
	}

	
	public long getEmailData_Id() {
		return emailData_Id;
	}


	public void setEmailData_Id(long emailData_Id) {
		this.emailData_Id = emailData_Id;
	}


	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public String getCcId() {
		return ccId;
	}

	public void setCcId(String ccId) {
		this.ccId = ccId;
	}

	public String getToId() {
		return toId;
	}

	public void setToId(String toId) {
		this.toId = toId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public long getUser_id() {
		return user_id;
	}


	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}


	public UserRegistration getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(UserRegistration userEmail) {
		this.userEmail = userEmail;
	}


	public ApprovedEmail getAppEmail() {
		return appEmail;
	}


	public void setAppEmail(ApprovedEmail appEmail) {
		this.appEmail = appEmail;
	} 


}
