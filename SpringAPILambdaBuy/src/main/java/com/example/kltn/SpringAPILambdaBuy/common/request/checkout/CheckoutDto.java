package com.example.kltn.SpringAPILambdaBuy.common.request.checkout;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;


public class CheckoutDto {
	private String id = UUID.randomUUID().toString();
	private String productName;
	private float subtotal;
	private float shipping;
	private float tax;
	private float total;

	public CheckoutDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CheckoutDto(String productName, String subtotal, String shipping, String tax, String total) {
		super();
		this.productName = productName;
        this.subtotal = Float.parseFloat(subtotal);
        this.shipping = Float.parseFloat(shipping);
        this.tax = Float.parseFloat(tax);
        this.total = Float.parseFloat(total);
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public String getSubtotal() {
		return String.format("%.2f", subtotal);
	}

	public String getShipping() {
		return String.format("%.2f", shipping);
	}

	public String getTax() {
		return String.format("%.2f", tax);
	}

	public String getTotal() {
		return String.format("%.2f", total);
	}
}
