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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="ApprovedEmail")
public class ApprovedEmail {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="appEmailId")
	private long appEmailId;	
	
	@Column(name="senderID")
	private String senderID;  	
	
	@Column(name="ccId")
	private String ccId; 	
	
	@Column(name="toId")
	private String toId;	
	
	@Column(name="body")
	private String body; 
	
	@Column(name="date_time")
	private String date_time; 
	
	@Column(name="amount")
	private double amount; 
	
	@Column(name="hide")
	private boolean hide;
	
	@Column(name="star")
	private boolean star;
	
	@Column(name="isDeleted")
	private boolean isDeleted; 		
	
	@Column(name="extra1")
	private String extra1;	
	
	@Column(name="extra2")
	private String extra2; 	
	
	@Column(name="createdOn")
	private String createdOn; 
	
	@Column(name="updatedOn")
	private String updatedOn; 	
	
	
	@Column(name="email_Id")
	private long email_Id ;	
	
	@Column(name="user_id")
	private long user_id; 	
	
	
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private EmailData emailData;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	  @JoinTable(name = "ApprovedEmail_Attachment",joinColumns = { @JoinColumn(name = "appEmailId") },
	            							inverseJoinColumns = { @JoinColumn(name = "fileId") })
	 private List<Attachment> attachment;
	 
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	  @JoinTable(name = "Email_Subject",joinColumns = { @JoinColumn(name = "appEmailId") },
	            							inverseJoinColumns = { @JoinColumn(name = "subjectId") })
	 private List<Subject> sub;
	 
	 
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "Email_Remark",joinColumns = { @JoinColumn(name = "appEmailId") },
		            							inverseJoinColumns = { @JoinColumn(name = "remarkId") })
	private List<Remark> remark;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "Email_Specification",joinColumns = { @JoinColumn(name = "appEmailId") },
		            							inverseJoinColumns = { @JoinColumn(name = "specificationId") })
	private List<Specification> spec;
	
	

	@ManyToOne
    @JoinColumn
    @JsonIgnore
    private UserRegistration userEmail;
	
	ApprovedEmail(){}
	
	public List<Remark> getRemark() {
		return remark;
	}

	public void setRemark(List<Remark> remark) {
		this.remark = remark;
	}

	public List<Subject> getSub() {
		return sub;
	}

	public void setSub(List<Subject> sub) {
		this.sub = sub;
	}


	public List<Attachment> getAttachment() {
		return attachment;
	}

	public void setAttachment(List<Attachment> attachment) {
		this.attachment = attachment;
	}

	public long getAppEmailId() {
		return appEmailId;
	}

	public void setAppEmailId(long appEmailId) {
		this.appEmailId = appEmailId;
	}

	public String getSenderID() {
		return senderID;
	}

	public void setSenderID(String senderID) {
		this.senderID = senderID;
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

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getDate_time() {
		return date_time;
	}

	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public boolean isHide() {
		return hide;
	}

	public void setHide(boolean hide) {
		this.hide = hide;
	}

	public boolean isStar() {
		return star;
	}

	public void setStar(boolean star) {
		this.star = star;
	}



	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getExtra1() {
		return extra1;
	}

	public void setExtra1(String extra1) {
		this.extra1 = extra1;
	}

	public String getExtra2() {
		return extra2;
	}

	public void setExtra2(String extra2) {
		this.extra2 = extra2;
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

	public long getEmail_Id() {
		return email_Id;
	}

	public void setEmail_Id(long email_Id) {
		this.email_Id = email_Id;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public EmailData getEmailData() {
		return emailData;
	}

	public void setEmailData(EmailData emailData) {
		this.emailData = emailData;
	}

	public UserRegistration getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(UserRegistration userEmail) {
		this.userEmail = userEmail;
	}

	public List<Specification> getSpec() {
		return spec;
	}

	public void setSpec(List<Specification> spec) {
		this.spec = spec;
	}
	
	
}
