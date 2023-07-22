package com.example.kltn.SpringAPILambdaBuy.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.kltn.SpringAPILambdaBuy.common.request.brand.CreateBrandDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.brand.UpdateBrandDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.user.UpdateUserDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.BrandResponseDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ResponseCommon;
import com.example.kltn.SpringAPILambdaBuy.common.response.UserResponseDto;
import com.example.kltn.SpringAPILambdaBuy.entities.BrandEntity;
import com.example.kltn.SpringAPILambdaBuy.service.BrandService;

@RestController
@RequestMapping(value = "", produces = "application/json;charset=UTF-8")
public class BrandController {
	private static final String APPLICATION_JSON_VALUE = "application/json";
	@Autowired
	private BrandService brandService;
	
	@GetMapping("/brands")
	public ResponseEntity<ResponseCommon<List<BrandResponseDto>>> findAllBrand(){
		List<BrandEntity> list = brandService.findAll();
		List<BrandResponseDto> listDto = new ArrayList<>();
		for (BrandEntity brand : list) {
			BrandResponseDto brandDto = new BrandResponseDto(brand.getId(), brand.getName(), brand.getFullName(), brand.getAddress(), brand.getIsDeleted(), brand.getCreatedDate(), brand.getCreatedBy(), brand.getUpdatedDate(), brand.getUpdatedBy());
			listDto.add(brandDto);
		}
		return ResponseEntity.ok().body(new ResponseCommon<>(200, true, "FIND_ALL_BRAND_SUCCESS", listDto));
	}
	
	@GetMapping("/brand/{id}")
	public ResponseEntity<ResponseCommon<BrandResponseDto>> findById(@PathVariable("id") String id) {
		BrandEntity brand = brandService.findById(id);
		if(brand != null) {
			BrandResponseDto brandDto = new BrandResponseDto(brand.getId(), brand.getName(), brand.getFullName(), brand.getAddress(), brand.getIsDeleted(), brand.getCreatedDate(), brand.getCreatedBy(), brand.getUpdatedDate(), brand.getUpdatedBy());
			return ResponseEntity.ok().body(new ResponseCommon<>(200, true, "FIND_BRAND_SUCCESS", brandDto));
		}
		return ResponseEntity.badRequest().body(new ResponseCommon<>(400, false, "BRAND_NOT_FOUND", null));
	}
	
	@GetMapping("/brand/name/{name}")
	public ResponseEntity<ResponseCommon<BrandResponseDto>> findByName(@PathVariable("name") String name) {
		BrandEntity brand = brandService.findByName(name);
		if(brand != null) {
			BrandResponseDto brandDto = new BrandResponseDto(brand.getId(), brand.getName(), brand.getFullName(), brand.getAddress(), brand.getIsDeleted(), brand.getCreatedDate(), brand.getCreatedBy(), brand.getUpdatedDate(), brand.getUpdatedBy());
			return ResponseEntity.ok().body(new ResponseCommon<>(200, true, "FIND_BRAND_SUCCESS", brandDto));
		}
		return ResponseEntity.badRequest().body(new ResponseCommon<>(400, false, "BRAND_NOT_FOUND", null));
	}
	
	@PostMapping("/brand/save")
	public ResponseEntity<ResponseCommon<?>> saveBrand(@RequestBody BrandEntity brand) {
		brandService.save(brand);
		return ResponseEntity.ok().body(new ResponseCommon<>(200, true, "SAVE_BRAND_SUCCESS"));
	}
	
	@GetMapping("/brand/create")
	public ResponseEntity<ResponseCommon<?>> createBrand(@RequestParam("name") String name, @RequestParam("fullName") String fullName, @RequestParam("address") String address) {
		CreateBrandDto createBrandDto = new CreateBrandDto(name, fullName, address);
		BrandResponseDto brandDto = brandService.create(createBrandDto);
		if(brandDto != null) {
			return ResponseEntity.ok().body(new ResponseCommon<>(200, true, "CREATE_BRAND_SUCCESS", brandDto));
		}
		return ResponseEntity.badRequest().body(new ResponseCommon<>(400, false, "CREATE_BRAND_FAIL", null));
	}
	
	@GetMapping(value = "/brand/update")
	public ResponseEntity<ResponseCommon<?>> updateBrand(@RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("fullName") String fullName, @RequestParam("address") String address) {
		UpdateBrandDto updateBrandDto = new UpdateBrandDto(id, name, fullName, address, false);
		BrandResponseDto brandDto = brandService.update(updateBrandDto);
		if(brandDto != null) {
			return ResponseEntity.ok().body(new ResponseCommon<>(200, true, "UPDATE_BRAND_SUCCESS", brandDto));
		}
		return ResponseEntity.badRequest().body(new ResponseCommon<>(400, false, "UPDATE_BRAND_FAIL", null));
	}	
	
	@GetMapping("/brand/delete/{id}")
	public ResponseEntity<ResponseCommon<BrandResponseDto>> deleteBrand(@PathVariable String id) {
		return ResponseEntity.ok().body(new ResponseCommon<BrandResponseDto>(200, true, "DELETE_BRAND_SUCCESS", brandService.deleteById(id)));
	}
}
