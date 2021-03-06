package com.crs.lt.beans;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class User {
	private UUID userId;
	private String userName;
	private String password;
	private LocalDate createDate;
	private String role;
	private int isApprove;
	private String firstName;
	private String lastName;
	private String emailId;
	private String dateOfBirth;
	private String address;
	private String location;
	private long pincode;
	private String country;
	private boolean session;
	public UUID getUserId() {
		return userId;
	}
	public void setUserId(UUID userId) {
		this.userId = userId;
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
	public LocalDate getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDate localDate) {
		this.createDate = localDate;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getIsApprove() {
		return isApprove;
	}
	public void setIsApprove(int isApprove) {
		this.isApprove = isApprove;
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
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public long getPincode() {
		return pincode;
	}
	public void setPincode(long pincode) {
		this.pincode = pincode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public boolean getSession() {
		return session;
	}
	public void setSession(boolean session) {
		this.session = session;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", createDate="
				+ createDate + ", role=" + role + ", isApprove=" + isApprove + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", emailId=" + emailId + ", dateOfBirth=" + dateOfBirth + ", address="
				+ address + ", location=" + location + ", pincode=" + pincode + ", country=" + country + ", session="
				+ session + "]";
	}
	
	
	
}
