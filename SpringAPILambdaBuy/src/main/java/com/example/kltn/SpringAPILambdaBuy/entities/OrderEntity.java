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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class OrderEntity {
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column
	private double subTotal;
	
	@Column
	private double shipping;
	
	@Column
	private double tax;
	
	@Column
	private double total;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private Collection<OrderDetailEntity> listOrderDetail;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;

	public OrderEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderEntity(double subTotal, double shipping, double tax, double total) {
		super();
		this.subTotal = subTotal;
		this.shipping = shipping;
		this.tax = tax;
		this.total = total;
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
}
