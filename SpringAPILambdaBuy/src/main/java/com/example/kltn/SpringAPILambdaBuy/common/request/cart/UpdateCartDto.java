package com.example.kltn.SpringAPILambdaBuy.common.request.cart;

import java.util.Set;

import com.example.kltn.SpringAPILambdaBuy.entities.ProfileEntity;
import com.example.kltn.SpringAPILambdaBuy.entities.ProductEntity;

public class UpdateCartDto {
	private String id;
	private int itemQuantity;
	private boolean isEmpty;
	private ProfileEntity customer;
	private Set<ProductEntity> listProduct;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	public boolean isEmpty() {
		return isEmpty;
	}
	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}
	public ProfileEntity getCustomer() {
		return customer;
	}
	public void setCustomer(ProfileEntity customer) {
		this.customer = customer;
	}
	public Set<ProductEntity> getListProduct() {
		return listProduct;
	}
	public void setListProduct(Set<ProductEntity> listProduct) {
		this.listProduct = listProduct;
	}
	public UpdateCartDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UpdateCartDto(String id, int itemQuantity, boolean isEmpty, ProfileEntity customer,
			Set<ProductEntity> listProduct) {
		super();
		this.id = id;
		this.itemQuantity = itemQuantity;
		this.isEmpty = isEmpty;
		this.customer = customer;
		this.listProduct = listProduct;
	}
}
