package com.example.kltn.SpringAPILambdaBuy.common.response;

import java.util.Date;

public class BrandResponseDto {
	private String id;
	private String name;
	private String fullName;
	private String address;
	private boolean isDeleted;
	private Date createdDate;
	private String createdBy;
	private Date updatedDate;
	private String updatedBy;
	
	public BrandResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BrandResponseDto(String id, String name, String fullName, String address) {
		super();
		this.id = id;
		this.name = name;
		this.fullName = fullName;
		this.address = address;
	}
	
	public BrandResponseDto(String id, String name, String fullName, String address, boolean isDeleted,
			Date createdDate, String createdBy, Date updatedDate, String updatedBy) {
		super();
		this.id = id;
		this.name = name;
		this.fullName = fullName;
		this.address = address;
		this.isDeleted = isDeleted;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
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
