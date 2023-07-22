package com.example.kltn.SpringAPILambdaBuy.common.request.supplier;

import java.util.Date;
import java.util.Set;

import com.example.kltn.SpringAPILambdaBuy.entities.ProductEntity;

public class UpdateSupplierDto {
	private String id;
	private String name;
	private String address;
	private String description;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public UpdateSupplierDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UpdateSupplierDto(String id, String name, String address, String description) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.description = description;
	}
}
