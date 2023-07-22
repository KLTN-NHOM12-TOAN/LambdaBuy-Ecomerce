package com.example.kltn.SpringAPILambdaBuy.entities;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity()
@Table(name = "product")
public class ProductEntity {
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column()
	private String name;
	
	@Column(columnDefinition="text")
	private String description;
	
	@Column
	private double unitPrice;
	
	@Column()
	private double discount;
	
	@Column()
	private String image;
	
	@Column
	private int inStock;
	
	@Column()
	private String country;
	
	@Column
	private int manufacturedDate;

	@Column()
	private boolean special;
	
	@CreatedDate()
	@Column
	private Date createdDate;
	
	@CreatedBy()
	@Column
	private String createdBy;
	
	@Column
	private Date updatedDate;
	
	@Column
	private String updatedBy;
	
	@Column
	private boolean isDeleted;

//	@OneToMany(mappedBy = "product")
//	Set<OrderDetail> listOrderDetail;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	@JsonIgnore
	private CategoryEntity category;
	
	@ManyToOne
	@JoinColumn(name = "brand_id")
	@JsonIgnore
	private BrandEntity brand;
	
	@ManyToOne
	@JoinColumn(name = "supplier_id")
	@JsonIgnore
	private SupplierEntity supplier;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private Collection<OrderDetailEntity> listOrderDetail;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private Set<ImageEntity> listImage;
	
	public ProductEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductEntity(String id, String name, String description, double unitPrice, double discount, String image,
			int inStock, int manufacturedDate, String country, boolean special, Date createdDate,
			String createdBy, Date updatedDate, String updatedBy, boolean isDeleted,
			CategoryEntity category, BrandEntity brand) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.unitPrice = unitPrice;
		this.discount = discount;
		this.image = image;
		this.inStock = inStock;
		this.manufacturedDate = manufacturedDate;
		this.country = country;
		this.special = special;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
		this.isDeleted = isDeleted;
//		this.listOrderDetail = listOrderDetail;
	}

	public ProductEntity(String name, String description, double unitPrice, double discount, String image,
			int inStock, int manufacturedDate, String country, boolean special, Date createdDate,
			String createdBy, Date updatedDate, String updatedBy, boolean isDeleted, 
			CategoryEntity category, BrandEntity brand, SupplierEntity supplier) {
		super();
		this.name = name;
		this.description = description;
		this.unitPrice = unitPrice;
		this.discount = discount;
		this.image = image;
		this.inStock = inStock;
		this.manufacturedDate = manufacturedDate;
		this.country = country;
		this.special = special;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
		this.isDeleted = isDeleted;
//		this.listOrderDetail = listOrderDetail;
		this.category = category;
		this.brand = brand;
		this.supplier = supplier;
	}

	public ProductEntity(String name,String country,double unitPrice, String image, int manufacturedDate , CategoryEntity category, BrandEntity brand,SupplierEntity supplier,int inStock, double discount,
			String description) {
		super();
		this.name = name;
		this.unitPrice = unitPrice;
		this.image = image;
		this.manufacturedDate = manufacturedDate;
		this.category = category;
		this.brand = brand;
		this.supplier=supplier;
		this.description = description;
		this.inStock = inStock;
		this.discount = discount;
		this.country = country;
	
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public int getInStock() {
		return inStock;
	}

	public void setInStock(int inStock) {
		this.inStock = inStock;
	}
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public boolean getSpecial() {
		return special;
	}

	public void setSpecial(boolean special) {
		this.special = special;
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

//	public Set<OrderDetail> getOrderDetails() {
//		return listOrderDetail;
//	}
//
//	public void setOrderDetails(Set<OrderDetail> listOrderDetail) {
//		this.listOrderDetail = listOrderDetail;
//	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public BrandEntity getBrand() {
		return brand;
	}

	public void setBrand(BrandEntity brand) {
		this.brand = brand;
	}

//	public Set<OrderDetail> getListOrderDetail() {
//		return listOrderDetail;
//	}
//
//	public void setListOrderDetail(Set<OrderDetail> listOrderDetail) {
//		this.listOrderDetail = listOrderDetail;
//	}

	public SupplierEntity getSupplier() {
		return supplier;
	}

	public void setSupplier(SupplierEntity supplier) {
		this.supplier = supplier;
	}
	
	public boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	public int getManufacturedDate() {
		return manufacturedDate;
	}
	public void setManufacturedDate(int manufacturedDate) {
		this.manufacturedDate = manufacturedDate;
	}

	public Collection<OrderDetailEntity> getListOrderDetail() {
		return listOrderDetail;
	}

	public void setListOrderDetail(Collection<OrderDetailEntity> listOrderDetail) {
		this.listOrderDetail = listOrderDetail;
	}
}
