package com.example.kltn.SpringAPILambdaBuy.common.request.image;

public class UploadImageDto {
	private String name;
	private String type;
	private String imageData;
	public UploadImageDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UploadImageDto(String name, String type, String imageData) {
		super();
		this.name = name;
		this.type = type;
		this.imageData = imageData;
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
	public String getImageData() {
		return imageData;
	}
	public void setImageData(String imageData) {
		this.imageData = imageData;
	}
}
