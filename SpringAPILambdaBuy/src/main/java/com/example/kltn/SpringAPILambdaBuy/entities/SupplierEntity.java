package com.example.kltn.SpringAPILambdaBuy.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "supplier")
public class SupplierEntity {
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column
	private String name;
	
	@Column
	private String address;
	
	@Column
	private String description;
	
	@OneToMany(mappedBy = "supplier")
	private Set<ProductEntity> listProduct;
	
	@Column
	private boolean isDeleted;
	
	@CreatedDate
	@Column
	private Date createdDate;
	
	@CreatedBy
	@Column
	private String createdBy;
	
	@Column
	private Date updatedDate;
	
	@Column
	private String updatedBy;
	

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

	public SupplierEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SupplierEntity(String name, String address, String description, Set<ProductEntity> listProduct,
			boolean isDeleted, Date createdDate, String createdBy, Date updatedDate, String updatedBy) {
		super();
		this.name = name;
		this.address = address;
		this.description = description;
		this.listProduct = listProduct;
		this.isDeleted = isDeleted;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
	}
	
	public SupplierEntity(String name, String address, String description, Set<ProductEntity> listProduct, boolean isDeleted, Date createdDate, String createdBy) {

		super();
		this.name = name;
		this.address = address;
		this.description = description;
		this.listProduct = listProduct;
		this.listProduct = listProduct;
		this.isDeleted = isDeleted;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
	}
	public SupplierEntity(String name, String address, String description) {
		super();
		this.address = address;
		this.description = description;
		this.name = name;

	}
	
	
	
}
