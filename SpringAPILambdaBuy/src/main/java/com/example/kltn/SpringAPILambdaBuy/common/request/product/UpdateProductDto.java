package com.example.kltn.SpringAPILambdaBuy.common.request.product;

import java.util.Date;

public class UpdateProductDto {
	private String id;
	private String name;
	private String description;
	private double unitPrice;
	private double discount;
	private String image;
	private int inStock;
	private String country;
	private int manufacturedDate;
	private boolean special;
	private boolean isDeleted;
	private String category;
	private String brand;
	private String supplier;
	public UpdateProductDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UpdateProductDto(String id, String name, String description, double unitPrice, double discount, String image,
			int inStock, String country, int manufacturedDate, boolean special, boolean isDeleted, String category,
			String brand, String supplier) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.unitPrice = unitPrice;
		this.discount = discount;
		this.image = image;
		this.inStock = inStock;
		this.country = country;
		this.manufacturedDate = manufacturedDate;
		this.special = special;
		this.isDeleted = isDeleted;
		this.category = category;
		this.brand = brand;
		this.supplier = supplier;
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
	public int getManufacturedDate() {
		return manufacturedDate;
	}
	public void setManufacturedDate(int manufacturedDate) {
		this.manufacturedDate = manufacturedDate;
	}
	public boolean getIsSpecial() {
		return special;
	}
	public void setIsSpecial(boolean special) {
		this.special = special;
	}
	public boolean getIsDeleted() {
		return isDeleted;
	}
	public void setÍDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	
	
	
}
