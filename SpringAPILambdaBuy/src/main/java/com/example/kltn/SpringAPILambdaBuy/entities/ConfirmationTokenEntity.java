package com.example.kltn.SpringAPILambdaBuy.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "token")
public class ConfirmationTokenEntity implements Serializable {
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(nullable = false)
	private String tokenCode;
	
	@Column(nullable = false)
	private LocalDateTime createdDate;
	
	@Column(nullable = false)
	private LocalDateTime expiresDate;
	
	private LocalDateTime confirmDate;
	
	@ManyToOne
	@JoinColumn(
			nullable = false,
			name = "user_id"
	)
	private UserEntity user;
	
	
	public ConfirmationTokenEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ConfirmationTokenEntity(String tokenCode, LocalDateTime createdDate, LocalDateTime expiredDate, UserEntity user) {
		super();
		this.tokenCode = tokenCode;
		this.createdDate = createdDate;
		this.expiresDate = expiredDate;
		this.user = user;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getTokenCode() {
		return tokenCode;
	}


	public void setTokenCode(String token) {
		this.tokenCode = token;
	}


	public LocalDateTime getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}


	public LocalDateTime getExpiresDate() {
		return expiresDate;
	}


	public void setExpiresDate(LocalDateTime expiresDate) {
		this.expiresDate = expiresDate;
	}


	public LocalDateTime getConfirmDate() {
		return confirmDate;
	}


	public void setConfirmDate(LocalDateTime confirmDate) {
		this.confirmDate = confirmDate;
	}


	public UserEntity getUser() {
		return user;
	}


	public void setUser(UserEntity user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "ConfirmationTokenEntity [id=" + id + ", tokenCode=" + tokenCode + ", createdDate=" + createdDate
				+ ", expiresDate=" + expiresDate + ", confirmDate=" + confirmDate + ", user=" + user + "]";
	}
}
