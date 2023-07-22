package com.example.kltn.SpringAPILambdaBuy.common.request.cart;

import com.example.kltn.SpringAPILambdaBuy.common.response.ProductResponseDto;

public class CartDto {
	private String productId;
	private String name;
	private double price;
	private int quantity;
	public CartDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartDto(String productId, String name, double price, int quantity) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
