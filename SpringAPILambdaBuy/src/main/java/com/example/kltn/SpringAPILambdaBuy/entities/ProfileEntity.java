package com.example.kltn.SpringAPILambdaBuy.entities;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "profile")
public class ProfileEntity {
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column
	private String phoneNumber;
	
	@Column
	private String address;
	
	@Column(columnDefinition = "TEXT", nullable = true)
	private String avatar;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private Date createdDate;
	
	@Column
	private String createdBy;
	
	@Column
	private Date updatedDate;
	
	@Column
	private String updatedBy;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "image_id", nullable = true)
	private ImageEntity image;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private UserEntity user;
	
	public ProfileEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProfileEntity(String id, String phoneNumber, String address, String avatar, String firstName,
			String lastName, UserEntity user) {
		super();
		this.id = id;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.avatar = avatar;
		this.firstName = firstName;
		this.lastName = lastName;
		this.user = user;
	}

	public ProfileEntity(String phoneNumber, String address, String avatar, String firstName, String lastName,
			UserEntity user) {
		super();
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.avatar = avatar;
		this.firstName = firstName;
		this.lastName = lastName;
		this.user = user;
	}
	

	public ProfileEntity(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	

	public ProfileEntity(String id, String phoneNumber, String address, String avatar, String firstName,
			String lastName, Date createdDate, String createdBy, Date updatedDate, String updatedBy) {
		super();
		this.id = id;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.avatar = avatar;
		this.firstName = firstName;
		this.lastName = lastName;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
	}
	
	public ProfileEntity(String phoneNumber, String address, String avatar, String firstName,
			String lastName, Date createdDate, String createdBy) {
		super();
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.avatar = avatar;
		this.firstName = firstName;
		this.lastName = lastName;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
	}
	
	public ProfileEntity(String phoneNumber, String address, String avatar, String firstName,
			String lastName, Date createdDate, String createdBy, UserEntity user) {
		super();
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.avatar = avatar;
		this.firstName = firstName;
		this.lastName = lastName;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.user = user;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public ImageEntity getImage() {
		return image;
	}

	public void setImage(ImageEntity image) {
		this.image = image;
	}
	
	
}
