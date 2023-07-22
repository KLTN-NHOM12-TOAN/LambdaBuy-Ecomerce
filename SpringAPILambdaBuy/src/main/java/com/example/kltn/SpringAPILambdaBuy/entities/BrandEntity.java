package com.example.kltn.SpringAPILambdaBuy.entities;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

@Entity()
@Table(name = "brand")
public class BrandEntity {
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column()
	private String name;
	
	@Column
	private String fullName;
	
	@Column()
	private String address;
	
	@OneToMany(mappedBy = "brand")
	private Set<ProductEntity> listProduct;
	
	@Column
	private boolean isDeleted;
	
	@Column
	private Date createdDate;
	
	@Column
	private String createdBy;
	
	@Column
	private Date updatedDate;
	
	@Column
	private String updatedBy;

	public BrandEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BrandEntity(String id, String name, String fullName, String address, Set<ProductEntity> listProduct) {
		super();
		this.id = id;
		this.name = name;
		this.fullName = fullName;
		this.address = address;
		this.listProduct = listProduct;
	}

	public BrandEntity(String name, String fullName, String address, Set<ProductEntity> listProduct) {
		super();
		this.name = name;
		this.fullName = fullName;
		this.address = address;
		this.listProduct = listProduct;
	}
	

	public BrandEntity(String name, String fullName, String address, Set<ProductEntity> listProduct, boolean isDeleted,
			Date createdDate, String createdBy, Date updatedDate, String updatedBy) {
		super();
		this.name = name;
		this.fullName = fullName;
		this.address = address;
		this.listProduct = listProduct;
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

	public Set<ProductEntity> getListProduct() {
		return listProduct;
	}

	public void setListProduct(Set<ProductEntity> listProduct) {
		this.listProduct = listProduct;
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
