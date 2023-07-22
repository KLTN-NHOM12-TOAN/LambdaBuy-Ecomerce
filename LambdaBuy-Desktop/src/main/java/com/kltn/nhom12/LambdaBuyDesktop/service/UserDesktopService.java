package com.kltn.nhom12.LambdaBuyDesktop.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.example.kltn.SpringAPILambdaBuy.common.request.user.CreateUserDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.user.CreateUserProfileDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.user.UpdateUserDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ResponseCommon;
import com.example.kltn.SpringAPILambdaBuy.common.response.UserResponseDto;
import com.example.kltn.SpringAPILambdaBuy.entities.UserEntity;
import com.example.kltn.SpringAPILambdaBuy.entities.UserRole;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeBase;
import com.fasterxml.jackson.databind.type.TypeBindings;
import com.kltn.nhom12.LambdaBuyDesktop.common.ConstantGlobal;

@Service
public class UserDesktopService  {
	private RestTemplate restTemplate;
	private ObjectMapper mapper;
	
	
	public UserDesktopService() {
		restTemplate = new RestTemplate();
		mapper = new ObjectMapper();
	}
	
	/**
	 * ObjectMapper mapper = new ObjectMapper();
		ResponseCommon response = userWebService.getAllUser();
		System.out.println(response);
	=>  ResponseCommon [success=true, code=200, message=FIND_ALL_USER_SUCCESS, errorMessage=null, data=[{id=74346d70-d551-4075-bf8a-dc57e847c882, email=vantoan10c2@gmail.com, username=vantoan, password=$2a$10$rxU2WrfrQ6ukYC7e4QUCVO/okHStgnX1AJ3pCidSe1FHrIlmr.ghi, role=CUSTOMER, createdDate=2022-10-28T16:34:45.000+00:00, createdBy=Toan Le, updatedDate=null, updatedBy=null}]]
		List<UserResponseDto> users = (List<UserResponseDto>) response.getData();
		System.out.println(users);
	=>  [{id=74346d70-d551-4075-bf8a-dc57e847c882, email=vantoan10c2@gmail.com, username=vantoan, password=$2a$10$rxU2WrfrQ6ukYC7e4QUCVO/okHStgnX1AJ3pCidSe1FHrIlmr.ghi, role=CUSTOMER, createdDate=2022-10-28T16:34:45.000+00:00, createdBy=Toan Le, updatedDate=null, updatedBy=null}]
		List<UserResponseDto> listUser = mapper.convertValue(response.getData(), new TypeReference<List<UserResponseDto>>() {});
		System.out.println(listUser);
	=>  [com.example.kltn.SpringAPILambdaBuy.common.response.UserResponseDto@522272d8]
		for (UserResponseDto userResponseDto : listUser) {
			System.out.println(userResponseDto);
		=>  [com.example.kltn.SpringAPILambdaBuy.common.response.UserResponseDto@522272d8]	
			System.out.println(userResponseDto.getPassword());
		=>	$2a$10$rxU2WrfrQ6ukYC7e4QUCVO/okHStgnX1AJ3pCidSe1FHrIlmr.ghi
		}
	 * @return
	 */
	public UserResponseDto getCurrentUser(String token) {
		String uri = ConstantGlobal.API_PARENT + "/getCurrentUser";
		ResponseEntity<ResponseCommon> response = restTemplate.postForEntity(uri, token, ResponseCommon.class);
		
//		ResponseEntity<ResponseCommon> response = restTemplate.getForEntity(uri, ResponseCommon.class);
		if(response.getBody().success) {
			UserResponseDto user = mapper.convertValue(response.getBody().data, new TypeReference<UserResponseDto>() {});
			return user;
		}
		return null;
	}
	
	
	public List<UserResponseDto> getAllUser(String token) {
		String uri = ConstantGlobal.API_PARENT + "/users";
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", token);
		HttpEntity<String> jwtEntity = new HttpEntity<String>(headers);
		// Use Token to get Response
		ResponseEntity<ResponseCommon> response = restTemplate.exchange(uri, HttpMethod.GET, jwtEntity,
				ResponseCommon.class);
		
		if(response.getBody().success) {
			List<UserResponseDto> listUser = mapper.convertValue(response.getBody().data, new TypeReference<List<UserResponseDto>>() {});
			List<UserResponseDto> result = new ArrayList<>();
			for (UserResponseDto userResponseDto : listUser) {
				if(!userResponseDto.getIsLocked()) {
					result.add(userResponseDto);
				}
			}
			return result;
		}
		return null;
	}
	
	public UserResponseDto getUserById(String id, String token) {
		String uri = ConstantGlobal.API_PARENT + "/user/" + id;
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", token);
		HttpEntity<String> jwtEntity = new HttpEntity<String>(headers);
		// Use Token to get Response
		ResponseEntity<ResponseCommon> response = restTemplate.exchange(uri, HttpMethod.GET, jwtEntity,
				ResponseCommon.class);
		if(response.getBody().success) {
			UserResponseDto user = mapper.convertValue(response.getBody().data, new TypeReference<UserResponseDto>() {});
			return user;
		}
		return null;
	}
	
	public UserResponseDto getUserByUsername(String username, String token) {
		String uri = ConstantGlobal.API_PARENT + "/user/name/" + username;
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", token);
		HttpEntity<String> jwtEntity = new HttpEntity<String>(headers);
		// Use Token to get Response
		ResponseEntity<ResponseCommon> response = restTemplate.exchange(uri, HttpMethod.GET, jwtEntity,
				ResponseCommon.class);
		if(response.getBody().success) {
			UserResponseDto user = mapper.convertValue(response.getBody().data, new TypeReference<UserResponseDto>() {});
			return user;
		}
		return null;
	}
	
	public UserResponseDto getUserByEmail(String email, String token) {
		String uri = ConstantGlobal.API_PARENT + "/user/email/" + email;
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", token);
		HttpEntity<String> jwtEntity = new HttpEntity<String>(headers);
		// Use Token to get Response
		ResponseEntity<ResponseCommon> response = restTemplate.exchange(uri, HttpMethod.GET, jwtEntity,
				ResponseCommon.class);
		if(response.getBody().success) {
			UserResponseDto user = mapper.convertValue(response.getBody().data, new TypeReference<UserResponseDto>() {});
			return user;
		}
		return null;
	}
	
	public ResponseCommon<?> saveUser(UserEntity user, String token) {
		String uri = ConstantGlobal.API_PARENT + "/user/save";
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", token);
		HttpEntity<String> jwtEntity = new HttpEntity<String>(headers);
		// Use Token to get Response
		ResponseEntity<ResponseCommon> response = restTemplate.exchange(uri, HttpMethod.POST, jwtEntity,
				ResponseCommon.class, user);
//		ResponseEntity<ResponseCommon> response = restTemplate.postForEntity(uri, user, ResponseCommon.class);
		return response.getBody();
	}
	
	public ResponseCommon<?> createUser(CreateUserDto createUserDto, String token) {
		String uri = ConstantGlobal.API_PARENT + "/user/create";
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", token);
		HttpEntity<String> jwtEntity = new HttpEntity<String>(headers);
		// Use Token to get Response
		ResponseEntity<ResponseCommon> response = restTemplate.exchange(uri, HttpMethod.POST, jwtEntity,
				ResponseCommon.class, createUserDto);
//		ResponseEntity<ResponseCommon> response = restTemplate.postForEntity(uri, createUserDto, ResponseCommon.class);
		return response.getBody();
	}
	
	public UserResponseDto createUserProfile(CreateUserProfileDto createUserProfileDto, String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.set("Authorization", token);
		
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("username", createUserProfileDto.getUsername());
		map.add("email", createUserProfileDto.getEmail());
		map.add("password", "123123");
		map.add("phoneNumber", createUserProfileDto.getPhoneNumber());
		map.add("address", createUserProfileDto.getAddress());
		map.add("avatar", createUserProfileDto.getAvatar());
		map.add("firstName", createUserProfileDto.getFirstName());
		map.add("lastName", createUserProfileDto.getLastName());
		
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
		
		String uri = ConstantGlobal.API_PARENT + "/user/create-user-profile";
		ResponseEntity<UserResponseDto> response = restTemplate.exchange(uri, HttpMethod.POST, request, UserResponseDto.class, map);
		if(response.getBody() != null) {
			 return response.getBody();
		}
		return null;
	}
	
	public ResponseCommon<?> updateUser(UpdateUserDto updateUserProfile, String token) {
		String uri = ConstantGlobal.API_PARENT + "/user/update";
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", token);
		HttpEntity<String> jwtEntity = new HttpEntity<String>(headers);
		// Use Token to get Response
		ResponseEntity<ResponseCommon> response = restTemplate.exchange(uri, HttpMethod.POST, jwtEntity,
				ResponseCommon.class, updateUserProfile);
//		ResponseEntity<ResponseCommon> response = restTemplate.postForEntity(uri, updateUserProfile, ResponseCommon.class);
		return response.getBody();
	}
	
	public ResponseCommon deteleUserById(String id, String token) {
		String uri = ConstantGlobal.API_PARENT + "/user/delete/" + id;
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", token);
		HttpEntity<String> jwtEntity = new HttpEntity<String>(headers);
		// Use Token to get Response
		ResponseEntity<ResponseCommon> response = restTemplate.exchange(uri, HttpMethod.GET, jwtEntity,
				ResponseCommon.class);
//		ResponseEntity<ResponseCommon> response = restTemplate.getForEntity(uri, ResponseCommon.class);
		if(response.getBody().success) {
			return response.getBody();
		}
		return null;
	}
}
