package com.example.kltn.SpringAPILambdaBuy.common.response;

public class OrderDetailResponseDto {
	private String id;
	private String description;
	private double subTotal;
	private double shipping;
	private double tax;
	private double total;
	private String payerFirtName;
	private String payerLastName;
	private String payerEmail;
	private String recidentName;
	private String shippingLine1;
	private String shippingCity;
	private String shippingCountryCode;
	private double shippingPostalCode;
	public OrderDetailResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDetailResponseDto(String id, String description, double subTotal, double shipping, double tax,
			double total, String payerFirtName, String payerLastName, String payerEmail, String recidentName,
			String shippingLine1, String shippingCity, String shippingCountryCode, double shippingPostalCode) {
		super();
		this.id = id;
		this.description = description;
		this.subTotal = subTotal;
		this.shipping = shipping;
		this.tax = tax;
		this.total = total;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
