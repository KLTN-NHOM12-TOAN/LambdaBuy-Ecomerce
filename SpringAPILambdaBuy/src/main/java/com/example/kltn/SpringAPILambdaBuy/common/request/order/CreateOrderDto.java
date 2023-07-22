package com.example.kltn.SpringAPILambdaBuy.common.request.order;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.OneToMany;

import com.example.kltn.SpringAPILambdaBuy.entities.ProductEntity;

public class CreateOrderDto {
	private double subTotal;
	private double shipping;
	private double tax;
	private double total;
	
	public CreateOrderDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CreateOrderDto(double subTotal, double shipping, double tax, double total) {
		super();
		this.subTotal = subTotal;
		this.shipping = shipping;
		this.tax = tax;
		this.total = total;
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
}
