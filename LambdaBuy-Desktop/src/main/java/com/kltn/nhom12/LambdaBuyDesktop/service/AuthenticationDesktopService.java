package com.kltn.nhom12.LambdaBuyDesktop.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.kltn.SpringAPILambdaBuy.common.request.authen.LoginDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.authen.RegisterDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.AuthResponse;
import com.example.kltn.SpringAPILambdaBuy.common.response.ResponseCommon;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kltn.nhom12.LambdaBuyDesktop.common.ConstantGlobal;

@Service
public class AuthenticationDesktopService {
	private RestTemplate restTemplate;
	private ObjectMapper mapper;
	
	
	public AuthenticationDesktopService() {
		restTemplate = new RestTemplate();
		mapper = new ObjectMapper();
	}
	
	public ResponseCommon register(RegisterDto registerDto) {
		String uri = ConstantGlobal.API_PARENT + "/authentication/register";
		ResponseEntity<ResponseCommon> response = restTemplate.postForEntity(uri, registerDto, ResponseCommon.class);
		return response.getBody();
	}
	
//	@Cacheable(cacheNames = "accessToken", key = "#auth.accessToken")
	public AuthResponse login (LoginDto loginDto) {
		String uri = ConstantGlobal.API_PARENT + "/authentication/login";
		ResponseEntity<ResponseCommon> response = restTemplate.postForEntity(uri, loginDto, ResponseCommon.class);
		if(response.getBody().success) {
			AuthResponse auth = mapper.convertValue(response.getBody().data, new TypeReference<AuthResponse>() {});
			return auth;
		}
		return null;
	}
}
