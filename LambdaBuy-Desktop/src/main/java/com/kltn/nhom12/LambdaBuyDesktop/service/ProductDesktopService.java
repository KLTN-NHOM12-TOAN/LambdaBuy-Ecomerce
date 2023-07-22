package com.kltn.nhom12.LambdaBuyDesktop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.example.kltn.SpringAPILambdaBuy.common.request.product.CreateProductDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.product.UpdateProductDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.supplier.CreateSupplierDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.supplier.UpdateSupplierDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ProductResponseDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ResponseCommon;
import com.example.kltn.SpringAPILambdaBuy.common.response.SupplierResponseDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kltn.nhom12.LambdaBuyDesktop.common.ConstantGlobal;

public class ProductDesktopService {
	private RestTemplate restTemplate;
	private ObjectMapper mapper;
	
	
	public ProductDesktopService() {
		restTemplate = new RestTemplate();
		mapper = new ObjectMapper();
	}
	
	public List<ProductResponseDto> getAll(String token) {
		String uri = ConstantGlobal.API_PARENT + "/products";
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", token);
		HttpEntity<String> jwtEntity = new HttpEntity<String>(headers);
		// Use Token to get Response
		ResponseEntity<ResponseCommon> response = restTemplate.exchange(uri, HttpMethod.GET, jwtEntity,
				ResponseCommon.class);
		
		if(response.getBody().success) {
			List<ProductResponseDto> listProduct = mapper.convertValue(response.getBody().data, new TypeReference<List<ProductResponseDto>>() {});
			List<ProductResponseDto> result = new ArrayList<>();
			for (ProductResponseDto productResponseDto : listProduct) {
				if(!productResponseDto.getIsDeleted()) {
					result.add(productResponseDto);
				}
			}
			return result;
		}
		return null;
	}
	
	public ProductResponseDto getById(String id, String token) {
		String uri = ConstantGlobal.API_PARENT + "/product/" + id;
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", token);
		HttpEntity<String> jwtEntity = new HttpEntity<String>(headers);
		// Use Token to get Response
		ResponseEntity<ResponseCommon> response = restTemplate.exchange(uri, HttpMethod.GET, jwtEntity,
				ResponseCommon.class);
		if(response.getBody().success) {
			ProductResponseDto product = mapper.convertValue(response.getBody().data, new TypeReference<ProductResponseDto>() {});
			return product;
		}
		return null;
	}
	
	public ProductResponseDto findContainName(String name, String token) {
		String uri = ConstantGlobal.API_PARENT + "/product/name/" + name;
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", token);
		HttpEntity<String> jwtEntity = new HttpEntity<String>(headers);
		// Use Token to get Response
		ResponseEntity<ResponseCommon> response = restTemplate.exchange(uri, HttpMethod.GET, jwtEntity,
				ResponseCommon.class);
		if(response.getBody().success) {
			ProductResponseDto product = mapper.convertValue(response.getBody().data, new TypeReference<ProductResponseDto>() {});
			return product;
		}
		return null;
	}
	
	public ResponseCommon<?> create(CreateProductDto createProductDto, String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.set("Authorization", token);
		
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("name", createProductDto.getName());
		map.add("description", createProductDto.getDescription());
		map.add("unitPrice", String.valueOf(createProductDto.getUnitPrice()));
		map.add("discount", String.valueOf(createProductDto.getDiscount()));
		map.add("image", createProductDto.getImage());
		map.add("inStock", String.valueOf(createProductDto.getInStock()));
		map.add("country", createProductDto.getCountry());
		map.add("manufactureDate", String.valueOf(createProductDto.getManufacturedDate()));
		map.add("special", String.valueOf(createProductDto.getIsSpecial()));
		map.add("category", createProductDto.getCategory());
		map.add("brand", createProductDto.getBrand());
		map.add("supplier", createProductDto.getSupplier());
		
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
		
		String uri = ConstantGlobal.API_PARENT + "/product/create";
		ResponseEntity<ResponseCommon> response = restTemplate.exchange(uri, HttpMethod.POST, request,
				ResponseCommon.class, createProductDto);
		if(response.getBody() != null) {
			 return response.getBody();
		}
		return null;
	}
	
	public ResponseCommon<?> update(UpdateProductDto updateProductDto, String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.set("Authorization", token);
		
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("id", updateProductDto.getId());
		map.add("name", updateProductDto.getName());
		map.add("description", updateProductDto.getDescription());
		map.add("unitPrice", String.valueOf(updateProductDto.getUnitPrice()));
		map.add("discount", String.valueOf(updateProductDto.getDiscount()));
		map.add("image", updateProductDto.getImage());
		map.add("inStock", String.valueOf(updateProductDto.getInStock()));
		map.add("country", updateProductDto.getCountry());
		map.add("manufactureDate", String.valueOf(updateProductDto.getManufacturedDate()));
		map.add("special", String.valueOf(updateProductDto.getIsSpecial()));
		map.add("category", updateProductDto.getCategory());
		map.add("brand", updateProductDto.getBrand());
		map.add("supplier", updateProductDto.getSupplier());
		
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
		
		String uri = ConstantGlobal.API_PARENT + "/product/update";
		ResponseEntity<ResponseCommon> response = restTemplate.exchange(uri, HttpMethod.POST, request,
				ResponseCommon.class, updateProductDto);
		if(response.getBody() != null) {
			 return response.getBody();
		}
		return null;
	}
	
	public ResponseCommon deteleById(String id, String token) {
		String uri = ConstantGlobal.API_PARENT + "/product/delete/" + id;
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
