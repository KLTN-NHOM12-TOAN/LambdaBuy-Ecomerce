package com.example.kltn.SpringAPILambdaBuy.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.kltn.SpringAPILambdaBuy.utils.CustomAuthorityDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
@Table(name = "user")
public class UserEntity implements UserDetails {
	@Id
	@PrimaryKeyJoinColumn
	private String id = UUID.randomUUID().toString();
	
	@Column(unique = true)
	private String username;
	
	@Column(unique = true)
	private String email;
	
	@Column
	private String password;
	
	@Column
	private boolean locked;
	
	@Column
	private boolean enabled;
	
	@Column
	@Enumerated(EnumType.STRING)
	private UserRole role;
	
	@Column
	@CreatedDate
	private Date createdDate;
	
	@Column
	@CreatedBy
	private String createdBy;
	
	@Column
	private Date updatedDate;
	
	@Column
	private String updatedBy;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	private ProfileEntity profile;
		
	@OneToMany(mappedBy = "user")
	private Set<OrderEntity> listOrder;

	@JsonDeserialize(using = CustomAuthorityDeserializer.class)
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
//		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.name());
//		return Collections.singletonList(authority);
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.name()));
		authorities.add(new SimpleGrantedAuthority(UserRole.CUSTOMER.name()));
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}
	
	@Override
	public String getUsername() {
		return email;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return !locked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
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

	public ProfileEntity getProfile() {
		return profile;
	}

	public void setProfile(ProfileEntity profile) {
		this.profile = profile;
	}
/*
	public AdminEntity getAdmin() {
		return admin;
	}

	public void setAdmin(AdminEntity admin) {
		this.admin = admin;
	}
*/
//	public Set<PaymentEntity> getListPayment() {
//		return listPayment;
//	}
//
//	public void setListPayment(Set<PaymentEntity> listPayment) {
//		this.listPayment = listPayment;
//	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	

	public UserEntity(String username, String email, String password, UserRole role, Date createdDate, String createdBy) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
	}
	
	public UserEntity(String username, String email, String password, UserRole role, Date createdDate, String createdBy, ProfileEntity profile) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.profile = profile;
	}
	

	public UserEntity(String username, String email, String password, boolean enabled, UserRole role, Date createdDate,
			String createdBy) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.role = role;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
	}
	
	public UserEntity(String username, String email, String password, boolean enabled, UserRole role, Date createdDate,
			String createdBy, ProfileEntity profile) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.role = role;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.profile = profile;
	}

	
	public UserEntity(String username, String email) {
		super();
		this.username = username;
		this.email = email;
	}

	public UserEntity(String id, String username, String email, Date updatedDate, String updatedBy) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
	}
	

	public UserEntity(String id, String username, String email, boolean locked, boolean enabled,
			Date updatedDate, String updatedBy, ProfileEntity profile) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.locked = locked;
		this.enabled = enabled;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
		this.profile = profile;
	}	

	public UserEntity(String id, String username, String email, String password, boolean locked, boolean enabled,
			UserRole role, Date createdDate, String createdBy, Date updatedDate, String updatedBy,
			ProfileEntity profile) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.locked = locked;
		this.enabled = enabled;
		this.role = role;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
		this.profile = profile;
	}


	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Set<OrderEntity> getListOrder() {
		return listOrder;
	}

	public void setListOrder(Set<OrderEntity> listOrder) {
		this.listOrder = listOrder;
	}	
}
