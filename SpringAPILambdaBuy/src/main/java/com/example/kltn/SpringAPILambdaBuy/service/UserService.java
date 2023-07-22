package com.example.kltn.SpringAPILambdaBuy.service;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.security.core.Authentication;

import com.example.kltn.SpringAPILambdaBuy.common.request.authen.LoginDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.authen.RegisterDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.profile.UpdateProfileDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.user.CreateUserDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.user.CreateUserProfileDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.user.UpdateUserProfileDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.user.UpdateUserDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ResponseCommon;
import com.example.kltn.SpringAPILambdaBuy.common.response.UserResponseDto;
import com.example.kltn.SpringAPILambdaBuy.entities.UserEntity;

public interface UserService {
	String currentUsername();
	String getAccessToken();
	UserEntity findById(String id);
	UserEntity findByUsername(String username);
	UserEntity findByEmail(String email);
	UserEntity getCurrentLoggedInUser(Authentication authentication);
	void saveUser(UserEntity user);
	UserEntity save(UserEntity user);
	UserResponseDto createUser(CreateUserDto createUserDto);
	UserResponseDto createUserProfile(CreateUserProfileDto createUserProfileDto);
	UserResponseDto updateUser(UpdateUserDto updateuserDto);
//	UserResponseDto updateUserAndProfile(UpdateUserProfileDto updateUserDto);
	UserEntity getUser(String username);
	ResponseCommon<List<UserResponseDto>> getUsers();
	ResponseCommon<?> deleteUser(String id);
	String isUserPresent(UserEntity user);
	String getUsernameFromToken(String token);
	
}
