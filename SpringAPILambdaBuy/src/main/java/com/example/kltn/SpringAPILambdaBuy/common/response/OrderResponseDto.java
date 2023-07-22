package com.example.kltn.SpringAPILambdaBuy.common.response;

import java.util.List;

public class OrderResponseDto {
	private String id;
	private double subTotal;
	private double shipping;
	private double tax;
	private double total;
//	private List<ProductResponseDto> listProduct;
	public OrderResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderResponseDto(String id, double subTotal, double shipping, double tax, double total) {
		super();
		this.id = id;
		this.subTotal = subTotal;
		this.shipping = shipping;
		this.tax = tax;
		this.total = total;
//		this.listProduct = listProduct;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	public double getShipping() {
		return shipping;
	}
	public void setShipping(double shipping) {
		this.shipping = shipping;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
//	public List<ProductResponseDto> getListProduct() {
//		return listProduct;
//	}
//	public void setListProduct(List<ProductResponseDto> listProduct) {
//		this.listProduct = listProduct;
//	}
}
