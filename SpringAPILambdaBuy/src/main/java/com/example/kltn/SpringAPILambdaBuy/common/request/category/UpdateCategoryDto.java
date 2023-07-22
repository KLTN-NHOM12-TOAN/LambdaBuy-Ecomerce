package com.example.kltn.SpringAPILambdaBuy.common.request.category;

public class UpdateCategoryDto {
	private String id;
	private String name;
	public UpdateCategoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UpdateCategoryDto(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
