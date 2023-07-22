package com.example.kltn.SpringAPILambdaBuy.common.request.user;

import java.util.Date;

import com.example.kltn.SpringAPILambdaBuy.common.response.ProfileResponseDto;
import com.example.kltn.SpringAPILambdaBuy.entities.UserRole;

public class CreateUserDto {
	private String username;
	private String email;
	private String password;
	private UserRole role;
	private Date createdDate;
	private String createdBy;
	private ProfileResponseDto profile;
	public CreateUserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CreateUserDto(String username, String email, String password, UserRole role, Date createdDate, String createdBy) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UserRole getRole() {
		return role;
	}
	public void setRole(UserRole role) {
		this.role = role;
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
	public ProfileResponseDto getProfile() {
		return profile;
	}
	public void setProfile(ProfileResponseDto profile) {
		this.profile = profile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
