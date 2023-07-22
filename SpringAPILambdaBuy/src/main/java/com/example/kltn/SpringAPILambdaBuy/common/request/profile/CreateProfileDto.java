package com.example.kltn.SpringAPILambdaBuy.common.request.profile;

import org.springframework.web.multipart.MultipartFile;

public class CreateProfileDto {
	private String phoneNumber;
	private String address;
	private String avatar;
	private String firstName;
	private String lastName;
	public CreateProfileDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CreateProfileDto(String phoneNumber, String address, String avatar, String firstName,
			String lastName) {
		super();
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.avatar = avatar;
		this.firstName = firstName;
		this.lastName = lastName;
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
	
	
}
