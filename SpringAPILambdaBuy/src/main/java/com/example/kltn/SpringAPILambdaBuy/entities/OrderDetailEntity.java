package com.example.kltn.SpringAPILambdaBuy.entities;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "orderdetail")
public class OrderDetailEntity {
	@Id
	private String id = UUID.randomUUID().toString();

	@ManyToOne
	@JoinColumn(name = "product_id")
	private ProductEntity product;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private OrderEntity order;
	
	@Column
	private String description;
	
	@Column
	private String payerFirtName;
	
	@Column
	private String payerLastName;
	
	@Column
	private String payerEmail;
	
	@Column
	private String recidentName;
	
	@Column
	private String shippingLine1;
	
	@Column 
	private String shippingCity;
	
	@Column
	private String shippingCountryCode;
	
	@Column
	private double shippingPostalCode;

	public OrderDetailEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDetailEntity(ProductEntity product, OrderEntity order, String description,
			String payerFirtName, String payerLastName, String payerEmail, String recidentName, String shippingLine1,
			String shippingCity, String shippingCountryCode, double shippingPostalCode) {
		super();
		this.product = product;
		this.order = order;
		this.description = description;
		this.payerFirtName = payerFirtName;
		this.payerLastName = payerLastName;
		this.payerEmail = payerEmail;
		this.recidentName = recidentName;
		this.shippingLine1 = shippingLine1;
		this.shippingCity = shippingCity;
		this.shippingCountryCode = shippingCountryCode;
		this.shippingPostalCode = shippingPostalCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPayerFirtName() {
		return payerFirtName;
	}

	public void setPayerFirtName(String payerFirtName) {
		this.payerFirtName = payerFirtName;
	}

	public String getPayerLastName() {
		return payerLastName;
	}

	public void setPayerLastName(String payerLastName) {
		this.payerLastName = payerLastName;
	}

	public String getPayerEmail() {
		return payerEmail;
	}

	public void setPayerEmail(String payerEmail) {
		this.payerEmail = payerEmail;
	}

	public String getRecidentName() {
		return recidentName;
	}

	public void setRecidentName(String recidentName) {
		this.recidentName = recidentName;
	}

	public String getShippingLine1() {
		return shippingLine1;
	}

	public void setShippingLine1(String shippingLine1) {
		this.shippingLine1 = shippingLine1;
	}

	public String getShippingCity() {
		return shippingCity;
	}

	public void setShippingCity(String shippingCity) {
		this.shippingCity = shippingCity;
	}

	public String getShippingCountryCode() {
		return shippingCountryCode;
	}

	public void setShippingCountryCode(String shippingCountryCode) {
		this.shippingCountryCode = shippingCountryCode;
	}

	public double getShippingPostalCode() {
		return shippingPostalCode;
	}

	public void setShippingPostalCode(double shippingPostalCode) {
		this.shippingPostalCode = shippingPostalCode;
	}
	
	

}
