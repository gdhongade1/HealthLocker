package com.email.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="UserRegistration")
public class UserRegistration {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_reg_id")
    private long user_reg_id;
	
	@Column(name="firstName")
    private String firstName;
	
	@Column(name="lastName")
    private String lastName;
    
	@Column(name="emailAddress",unique=true)
    private String emailAddress;
    
	@Column(name="mobileNumber")
    private String mobileNumber;
    
	@Column(name="password")
    private String password;
    
	@Column(name="dob")
    private String dob;
    
	@Column(name="education")
    private String education;
    
	@Column(name="gender")
    private String gender;
    
	@Column(name="status")
    private String status;
    
	@Column(name="planID")
    private long  planID;
	
	@Column(name="enabled")
	private boolean enabled;
	
	@Column(name="role")
	private String role;
    
    
    public UserRegistration() {
		super();
	}
 
    @OneToMany(mappedBy = "userAdd", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<UserAddress> address;
    
    @OneToMany(mappedBy = "userEmail", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<EmailData> emailData;
    
    @OneToMany(mappedBy = "userEmail", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<ApprovedEmail> approvedEmail;
   

	public long getUser_reg_id() {
		return user_reg_id;
	}

	public void setUser_reg_id(long user_reg_id) {
		this.user_reg_id = user_reg_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	
	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		status = status;
	}

	public long getPlanID() {
		return planID;
	}

	public void setPlanID(long planID) {
		this.planID = planID;
	}

	public List<UserAddress> getAddress() {
		return address;
	}

	public void setAddress(List<UserAddress> address) {
		this.address = address;
	}

	public List<EmailData> getEmailData() {
		return emailData;
	}

	public void setEmailData(List<EmailData> emailData) {
		this.emailData = emailData;
	}

	public List<ApprovedEmail> getApprovedEmail() {
		return approvedEmail;
	}

	public void setApprovedEmail(List<ApprovedEmail> approvedEmail) {
		this.approvedEmail = approvedEmail;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
    
}
