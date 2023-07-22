package com.example.kltn.SpringAPILambdaBuy.common.request.category;

public class CreateCategoryDto {
	private String name;
	public CreateCategoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CreateCategoryDto(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
