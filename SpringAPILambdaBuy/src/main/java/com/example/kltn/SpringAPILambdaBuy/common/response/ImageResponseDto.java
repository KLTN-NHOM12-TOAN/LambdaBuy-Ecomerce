package com.example.kltn.SpringAPILambdaBuy.common.response;

public class ImageResponseDto {
	private String id;
	private String name;
	private String type;
	public ImageResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ImageResponseDto(String id, String name, String type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
