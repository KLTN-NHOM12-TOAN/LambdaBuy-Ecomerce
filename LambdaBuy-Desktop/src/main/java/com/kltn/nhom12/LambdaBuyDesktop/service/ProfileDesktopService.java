package com.kltn.nhom12.LambdaBuyDesktop.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.example.kltn.SpringAPILambdaBuy.common.request.profile.UpdateProfileDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ProfileResponseDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ResponseCommon;
import com.example.kltn.SpringAPILambdaBuy.common.response.UserResponseDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kltn.nhom12.LambdaBuyDesktop.common.ConstantGlobal;

public class ProfileDesktopService {
	private RestTemplate restTemplate;
	private ObjectMapper mapper;
	
	public ProfileDesktopService() {
		restTemplate = new RestTemplate();
		mapper = new ObjectMapper();
	}
	
	public ProfileResponseDto getProfileById(String id) {
		String uri = ConstantGlobal.API_PARENT + "/profile/" + id;
		ResponseEntity<ResponseCommon> response = restTemplate.getForEntity(uri, ResponseCommon.class);
		if(response.getBody().success) {
			ProfileResponseDto profile = mapper.convertValue(response.getBody().data, new TypeReference<ProfileResponseDto>() {});
			return profile;
		}
		return null;
	}
	
	public ResponseCommon updateProfile(UpdateProfileDto updateProfileDto, String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.set("Authorization", token);
		
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("id", updateProfileDto.getId());
		map.add("phoneNumber", updateProfileDto.getPhoneNumber());
		map.add("address", updateProfileDto.getAddress());
		map.add("avatar", updateProfileDto.getAvatar());
		map.add("firstName", updateProfileDto.getFirstName());
		map.add("lastName", updateProfileDto.getLastName());
		
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
		
		String uri = ConstantGlobal.API_PARENT + "/profile/update";
		ResponseEntity<ResponseCommon> response = restTemplate.exchange(uri, HttpMethod.POST, request, ResponseCommon.class, map);

		if(response.getBody().success) {
			 return response.getBody();
		}
		return null;
	}
}
