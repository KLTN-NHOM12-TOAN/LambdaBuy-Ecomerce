package com.kltn.nhom12.LambdaBuyDesktop.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.kltn.SpringAPILambdaBuy.common.request.category.CreateCategoryDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.category.UpdateCategoryDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.supplier.CreateSupplierDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.supplier.UpdateSupplierDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.CategoryResponseDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ResponseCommon;
import com.example.kltn.SpringAPILambdaBuy.common.response.SupplierResponseDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kltn.nhom12.LambdaBuyDesktop.common.ConstantGlobal;

public class SupplierDesktopService {
	private RestTemplate restTemplate;
	private ObjectMapper mapper;
	
	
	public SupplierDesktopService() {
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
	
	
	public List<SupplierResponseDto> getAll(String token) {
		String uri = ConstantGlobal.API_PARENT + "/suppliers";
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", token);
		HttpEntity<String> jwtEntity = new HttpEntity<String>(headers);
		// Use Token to get Response
		ResponseEntity<ResponseCommon> response = restTemplate.exchange(uri, HttpMethod.GET, jwtEntity,
				ResponseCommon.class);
		
		if(response.getBody().success) {
			List<SupplierResponseDto> listSupplier = mapper.convertValue(response.getBody().data, new TypeReference<List<SupplierResponseDto>>() {});
			List<SupplierResponseDto> result = new ArrayList<>();
			for (SupplierResponseDto supplierResponseDto : listSupplier) {
				if(!supplierResponseDto.isDeleted()) {
					result.add(supplierResponseDto);
				}
			}
			return result;
		}
		return null;
	}
	
	public SupplierResponseDto getById(String id, String token) {
		String uri = ConstantGlobal.API_PARENT + "/supplier/" + id;
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", token);
		HttpEntity<String> jwtEntity = new HttpEntity<String>(headers);
		// Use Token to get Response
		ResponseEntity<ResponseCommon> response = restTemplate.exchange(uri, HttpMethod.GET, jwtEntity,
				ResponseCommon.class);
		if(response.getBody().success) {
			SupplierResponseDto supplier = mapper.convertValue(response.getBody().data, new TypeReference<SupplierResponseDto>() {});
			return supplier;
		}
		return null;
	}
	
	public SupplierResponseDto getByName(String name, String token) {
		String uri = ConstantGlobal.API_PARENT + "/supplier/name/" + name;
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", token);
		HttpEntity<String> jwtEntity = new HttpEntity<String>(headers);
		// Use Token to get Response
		ResponseEntity<ResponseCommon> response = restTemplate.exchange(uri, HttpMethod.GET, jwtEntity,
				ResponseCommon.class);
		if(response.getBody().success) {
			SupplierResponseDto supplier = mapper.convertValue(response.getBody().data, new TypeReference<SupplierResponseDto>() {});
			return supplier;
		}
		return null;
	}
	
	public ResponseCommon<?> create(CreateSupplierDto createSupplierDto, String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", token);
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		String uri = ConstantGlobal.API_PARENT + "/supplier/create";
		
		String urlTemplate = UriComponentsBuilder.fromHttpUrl(uri)
		        .queryParam("name", "{name}")
		        .queryParam("address", "{address}")
		        .queryParam("description", "{description}")
		        .encode()
		        .toUriString();
		
		Map<String, String> params = new HashMap<>();
		params.put("name", createSupplierDto.getName());
		params.put("address", createSupplierDto.getAddress());
		params.put("description", createSupplierDto.getDescription());
		
		HttpEntity<ResponseCommon> response = restTemplate.exchange(
		        urlTemplate,
		        HttpMethod.GET,
		        entity,
		        ResponseCommon.class,
		        params
		);
		return response.getBody();
	}
	
	public ResponseCommon<?> update(UpdateSupplierDto updateSupplierDto, String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", token);
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		String uri = ConstantGlobal.API_PARENT + "/supplier/update";
		
		String urlTemplate = UriComponentsBuilder.fromHttpUrl(uri)
		        .queryParam("id", "{id}")
		        .queryParam("name", "{name}")
		        .queryParam("address", "{address}")
		        .queryParam("description", "{description}")
		        .encode()
		        .toUriString();
		
		Map<String, String> params = new HashMap<>();
		params.put("id", updateSupplierDto.getId());
		params.put("name", updateSupplierDto.getName());
		params.put("address", updateSupplierDto.getAddress());
		params.put("description", updateSupplierDto.getDescription());
		
		HttpEntity<ResponseCommon> response = restTemplate.exchange(
		        urlTemplate,
		        HttpMethod.GET,
		        entity,
		        ResponseCommon.class,
		        params
		);
		return response.getBody();
	}
	
	public ResponseCommon deteleById(String id, String token) {
		String uri = ConstantGlobal.API_PARENT + "/supplier/delete/" + id;
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
