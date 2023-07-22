package com.example.kltn.SpringAPILambdaBuy.common.response;

import java.util.Date;

public class ProfileResponseDto {
	private String id;
	private String phoneNumber;
	private String address;
	private String avatar;
	private String firstName;
	private String lastName;
	private Date createdDate;
	private String createdBy;
	private Date updatedDate;
	private String updatedBy;
	
	public ProfileResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProfileResponseDto(String id, String phoneNumber, String address, String avatar, String firstName,
			String lastName) {
		super();
		this.id = id;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.avatar = avatar;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public ProfileResponseDto(String id, String phoneNumber, String address, String avatar, String firstName,
			String lastName, Date createdDate, String createdBy, Date updatedDate, String updatedBy) {
		super();
		this.id = id;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.avatar = avatar;
		this.firstName = firstName;
		this.lastName = lastName;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
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
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
}
