package com.example.kltn.SpringAPILambdaBuy.common.request.order;

public class OrderDto {
	private String description;
	private String userEmail;
	private String username;
	
	public OrderDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public OrderDto(String description, String userEmail, String username) {
		super();
		this.description = description;
		this.userEmail = userEmail;
		this.username = username;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
