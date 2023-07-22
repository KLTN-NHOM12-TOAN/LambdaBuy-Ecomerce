package com.example.kltn.SpringAPILambdaBuy.common.request.brand;

import java.util.Date;

import javax.persistence.Column;

public class CreateBrandDto {
	private String name;
	private String fullName;
	private String address;
	
	public CreateBrandDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CreateBrandDto(String name, String fullName, String address) {
		super();
		this.name = name;
		this.fullName = fullName;
		this.address = address;
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
}
