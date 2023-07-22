package com.kltn.nhom12.LambdaBuyDesktop.service;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.kltn.SpringAPILambdaBuy.common.request.brand.CreateBrandDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.brand.UpdateBrandDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.BrandResponseDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ResponseCommon;
import com.example.kltn.SpringAPILambdaBuy.common.response.UserResponseDto;
import com.example.kltn.SpringAPILambdaBuy.entities.BrandEntity;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kltn.nhom12.LambdaBuyDesktop.common.ConstantGlobal;

public class BrandDesktopService {
	
	private RestTemplate restTemplate;
	private ObjectMapper mapper;
	
	public BrandDesktopService() {
		restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
		mapper = new ObjectMapper();
	}
	
	public List<BrandResponseDto> getAll(String token){
		String uri = ConstantGlobal.API_PARENT + "/brands";
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", token);
		HttpEntity<String> jwtEntity = new HttpEntity<String>(headers);
		// Use Token to get Response
		ResponseEntity<ResponseCommon> response = restTemplate.exchange(uri, HttpMethod.GET, jwtEntity,
				ResponseCommon.class);
		
		if(response.getBody().success) {
			List<BrandResponseDto> listBrand = mapper.convertValue(response.getBody().data, new TypeReference<List<BrandResponseDto>>() {});
			List<BrandResponseDto> result = new ArrayList<>();
			for (BrandResponseDto brandResponseDto : listBrand) {
				if(!brandResponseDto.getIsDeleted()) {
					result.add(brandResponseDto);
				}
			}
			return result;
		}
		return null;
	}
	
	public BrandResponseDto getById(String id, String token) {
		String uri = ConstantGlobal.API_PARENT + "/brand/" + id;
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", token);
		HttpEntity<String> jwtEntity = new HttpEntity<String>(headers);
		// Use Token to get Response
		ResponseEntity<ResponseCommon> response = restTemplate.exchange(uri, HttpMethod.GET, jwtEntity,
				ResponseCommon.class);
		if(response.getBody().success) {
			BrandResponseDto brand = mapper.convertValue(response.getBody().data, new TypeReference<BrandResponseDto>() {});
			return brand;
		}
		return null;
	}
	
	public ResponseCommon<?> save(BrandEntity brand, String token) {
		String uri = ConstantGlobal.API_PARENT + "/brand/save";
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", token);
		HttpEntity<String> jwtEntity = new HttpEntity<String>(headers);
		// Use Token to get Response
//		ResponseEntity<ResponseCommon> response = restTemplate.exchange(uri, HttpMethod.POST, jwtEntity,
//				ResponseCommon.class, brand);
		ResponseEntity<ResponseCommon> response = restTemplate.postForEntity(uri, jwtEntity, ResponseCommon.class, brand);
		return response.getBody();
	}
	
	public ResponseCommon<?> create(CreateBrandDto createBrandDto, String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", token);
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		String uri = ConstantGlobal.API_PARENT + "/brand/create";
		
		String urlTemplate = UriComponentsBuilder.fromHttpUrl(uri)
		        .queryParam("name", "{name}")
		        .queryParam("fullName", "{fullName}")
		        .queryParam("address", "{address}")
		        .encode()
		        .toUriString();
		
		Map<String, String> params = new HashMap<>();
		params.put("name", createBrandDto.getName());
		params.put("fullName", createBrandDto.getFullName());
		params.put("address", createBrandDto.getAddress());
		
		HttpEntity<ResponseCommon> response = restTemplate.exchange(
		        urlTemplate,
		        HttpMethod.GET,
		        entity,
		        ResponseCommon.class,
		        params
		);
		return response.getBody();
	}
	
	public ResponseCommon<?> update(UpdateBrandDto updateBrandDto, String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", token);
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		String uri = ConstantGlobal.API_PARENT + "/brand/update";
		
		String urlTemplate = UriComponentsBuilder.fromHttpUrl(uri)
		        .queryParam("id", "{id}")
		        .queryParam("name", "{name}")
		        .queryParam("fullName", "{fullName}")
		        .queryParam("address", "{address}")
		        .encode()
		        .toUriString();
		
		Map<String, String> params = new HashMap<>();
		params.put("id", updateBrandDto.getId());
		params.put("name", updateBrandDto.getName());
		params.put("fullName", updateBrandDto.getFullName());
		params.put("address", updateBrandDto.getAddress());
		
		HttpEntity<ResponseCommon> response = restTemplate.exchange(
		        urlTemplate,
		        HttpMethod.GET,
		        entity,
		        ResponseCommon.class,
		        params
		);
		return response.getBody();
//		HttpHeaders headers = new HttpHeaders();
//		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
//		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
//		headers.set("Authorization", token);
//		HttpEntity<String> jwtEntity = new HttpEntity<String>(headers);
//		String uri = ConstantGlobal.API_PARENT + "/brand/update";
////		ResponseEntity<ResponseCommon> response = restTemplate.exchange(uri, HttpMethod.POST, jwtEntity,
////				ResponseCommon.class, updateBrandDto);
//		ResponseEntity<ResponseCommon> response = restTemplate.exchange(uri, HttpMethod.POST, jwtEntity, ResponseCommon.class, updateBrandDto);;
//		return response.getBody();
	}
	
	public ResponseCommon<?> deleteById(String id, String token) {
		String uri = ConstantGlobal.API_PARENT + "/brand/delete/" + id;
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", token);
		HttpEntity<String> jwtEntity = new HttpEntity<String>(headers);
		ResponseEntity<ResponseCommon> response = restTemplate.exchange(uri, HttpMethod.GET, jwtEntity,
				ResponseCommon.class);
		if(response.getBody().success) {
			return response.getBody();
		}
		return null;
	}
}
