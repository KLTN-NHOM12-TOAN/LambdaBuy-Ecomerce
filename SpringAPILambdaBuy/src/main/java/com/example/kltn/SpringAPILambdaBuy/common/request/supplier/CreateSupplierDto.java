package com.example.kltn.SpringAPILambdaBuy.common.request.supplier;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import com.example.kltn.SpringAPILambdaBuy.entities.ProductEntity;

public class CreateSupplierDto {
	private String name;
	private String address;
	private String description;
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
	public CreateSupplierDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CreateSupplierDto(String name, String address, String description) {
		super();
		this.name = name;
		this.address = address;
		this.description = description;
	}
}
