package com.example.kltn.SpringAPILambdaBuy.common.response;

import java.util.Date;

import com.example.kltn.SpringAPILambdaBuy.entities.UserRole;

public class UserResponseDto {
	private String id;
	private String email;
	private String username;
	private String password;
	private UserRole role;
	private Date createdDate;
	private String createdBy;
	private Date updatedDate;
	private String updatedBy;
	private boolean isEnabled;
	private boolean isLocked;
	private ProfileResponseDto profile;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	
	public UserRole getRole() {
		return role;
	}
	public void setRole(UserRole role) {
		this.role = role;
	}
	
	public boolean getIsEnabled() {
		return isEnabled;
	}
	public void setIsEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	public boolean getIsLocked() {
		return isLocked;
	}
	public void setIsLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}
	
	public ProfileResponseDto getProfile() {
		return profile;
	}
	public void setProfileDto(ProfileResponseDto profile) {
		this.profile = profile;
	}
	public UserResponseDto(String id, String email, String username, String password, UserRole role, Date createdDate,
			String createdBy, Date updatedDate, String updatedBy, ProfileResponseDto profile) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.password = password;
		this.role = role;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
		this.profile = profile;
	}
	
	public UserResponseDto(String id, String email, String username, String password, UserRole role, Date createdDate,
			String createdBy, Date updatedDate, String updatedBy) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.password = password;
		this.role = role;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
	}
	
	public UserResponseDto(String id, String email, String username, String password, UserRole role, boolean isEnabled, boolean isLocked, Date createdDate,
			String createdBy, Date updatedDate, String updatedBy, ProfileResponseDto profile) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.password = password;
		this.role = role;
		this.isEnabled = isEnabled;
		this.isLocked = isLocked;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
		this.profile = profile;
	}
	
	public UserResponseDto(String id, String email, String username, String password, UserRole role, Date createdDate,
			String createdBy, ProfileResponseDto profile) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.password = password;
		this.role = role;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.profile = profile;
	}
	public UserResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserResponseDto(String username) {
		super();
		this.username = username;
	}
	
	
}
