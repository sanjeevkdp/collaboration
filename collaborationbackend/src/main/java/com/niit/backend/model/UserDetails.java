package com.niit.backend.model;

import java.util.UUID;

public class UserDetails {
	private String userDetails_id;
	private String userName;
	private String password;
	private String email;
	private String gender;
	private String phoneNo;
	private String userDetails_Name;
	private boolean enabled;
	private String status;
	private String is_notify;
	public String getUserDetails_id() {
		return userDetails_id;
	}
	public void setUserDetails_id(String userDetails_id) {
		this.userDetails_id = userDetails_id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getUserDetails_Name() {
		return userDetails_Name;
	}
	public void setUserDetails_Name(String userDetails_Name) {
		this.userDetails_Name = userDetails_Name;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getIs_notify() {
		return is_notify;
	}
	public void setIs_notify(String is_notify) {
		this.is_notify = is_notify;
	}
	public UserDetails(){
		this.userDetails_id="USID"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	

}