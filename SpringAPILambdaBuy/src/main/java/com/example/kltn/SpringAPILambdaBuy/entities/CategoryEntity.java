package com.example.kltn.SpringAPILambdaBuy.entities;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity()
@Table(name = "category")
public class CategoryEntity {
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column()
	private String name;
	
	@OneToMany(mappedBy = "category")
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

	public CategoryEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoryEntity(String id, String name, Set<ProductEntity> listProduct) {
		super();
		this.id = id;
		this.name = name;
		this.listProduct = listProduct;
	}

	public CategoryEntity(String name, Set<ProductEntity> listProduct) {
		super();
		this.name = name;
		this.listProduct = listProduct;
	}
	
	public CategoryEntity(String name, Set<ProductEntity> listProduct, boolean isDeleted, Date createdDate,
			String createdBy, Date updatedDate, String updatedBy) {
		super();
		this.name = name;
		this.listProduct = listProduct;
		this.isDeleted = isDeleted;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
	}

	public CategoryEntity(String name, boolean isDeleted, Date createdDate, String createdBy, Date updatedDate,
			String updatedBy) {
		super();
		this.name = name;
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
