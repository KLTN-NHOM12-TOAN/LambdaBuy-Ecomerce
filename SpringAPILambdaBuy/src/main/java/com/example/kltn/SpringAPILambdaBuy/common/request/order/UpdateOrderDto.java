package com.example.kltn.SpringAPILambdaBuy.common.request.order;

import java.util.Date;

public class UpdateOrderDto {
	private String id;
	private Date shippedDate;
	private String shippedAddress;
	private double total;
	private String description;
}
