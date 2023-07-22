package com.example.kltn.SpringAPILambdaBuy.common.request.brand;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.kltn.SpringAPILambdaBuy.entities.ProductEntity;

public class UpdateBrandDto {
	private String id;
	private String name;
	private String fullName;
	private String address;
	private boolean isDeleted;
	
	public UpdateBrandDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UpdateBrandDto(String id, String name, String fullName, String address, boolean isDeleted) {
		super();
		this.id = id;
		this.name = name;
		this.fullName = fullName;
		this.address = address;
		this.isDeleted = isDeleted;
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
	
}
