package com.email.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="UserAddress")
public class UserAddress {
		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="address_id")
	    private long address_id;
		
		@Column(name="pinCode")
		private int pinCode;
		
		@Column(name="area")
	    private String area;
		
		@Column(name="city")
	    private String city;
		
		@Column(name="state")
	    private String state;
		
		@Column(name="user_id")
	    private Long user_id;
	    
	    @ManyToOne
	    @JoinColumn
	    @JsonIgnore
	    private UserRegistration userAdd;
	    
		public UserAddress() {
	    }

		public long getAddress_id() {
			return address_id;
		}

		public void setAddress_id(long address_id) {
			this.address_id = address_id;
		}


		public int getPinCode() {
			return pinCode;
		}


		public void setPinCode(int pinCode) {
			this.pinCode = pinCode;
		}


		public String getArea() {
			return area;
		}


		public void setArea(String area) {
			this.area = area;
		}


		public String getCity() {
			return city;
		}


		public void setCity(String city) {
			this.city = city;
		}


		public String getState() {
			return state;
		}


		public void setState(String state) {
			this.state = state;
		}



		public UserRegistration getUserAdd() {
			return userAdd;
		}

		public void setUserAdd(UserRegistration userAdd) {
			this.userAdd = userAdd;
		}

		public Long getUser_id() {
			return user_id;
		}


		public void setUser_id(Long user_id) {
			this.user_id = user_id;
		}


		

}
