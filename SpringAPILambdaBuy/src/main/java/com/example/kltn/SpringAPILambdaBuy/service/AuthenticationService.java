package com.example.kltn.SpringAPILambdaBuy.service;

import com.example.kltn.SpringAPILambdaBuy.common.request.authen.LoginDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.authen.RegisterDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ResponseCommon;
import com.example.kltn.SpringAPILambdaBuy.entities.UserEntity;

public interface AuthenticationService {
	ResponseCommon<?> seedAdmin();
	ResponseCommon<?> register(RegisterDto registerDto); 
	ResponseCommon<?> login(LoginDto loginDto);
	ResponseCommon<?> confirmToken(String token);
	void activeUser(String email);
}
