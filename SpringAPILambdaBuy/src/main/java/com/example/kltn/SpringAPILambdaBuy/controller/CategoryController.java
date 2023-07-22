package com.example.kltn.SpringAPILambdaBuy.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
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

import com.example.kltn.SpringAPILambdaBuy.common.request.category.CreateCategoryDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.category.UpdateCategoryDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.BrandResponseDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.CategoryResponseDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ResponseCommon;
import com.example.kltn.SpringAPILambdaBuy.entities.BrandEntity;
import com.example.kltn.SpringAPILambdaBuy.entities.CategoryEntity;
import com.example.kltn.SpringAPILambdaBuy.service.BrandService;
import com.example.kltn.SpringAPILambdaBuy.service.CategoryService;



@RestController
@RequestMapping("")
public class CategoryController {
	private static final String APPLICATION_JSON_VALUE = "application/json";
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/categories")
	public ResponseEntity<ResponseCommon<List<CategoryResponseDto>>> findAll(){
		List<CategoryEntity> list = categoryService.findAll();
		List<CategoryResponseDto> listDto = new ArrayList<>();
		for (CategoryEntity category : list) {
			CategoryResponseDto categoryDto = new CategoryResponseDto(category.getId(), category.getName(), category.getIsDeleted(), new Date(), "admin", null, null);
			listDto.add(categoryDto);
		}
		return ResponseEntity.ok().body(new ResponseCommon<List<CategoryResponseDto>>(200, true, "FIND_ALL_CATEGORY_SUCCESS", listDto));
	}
	
	@GetMapping("/category/{id}")
	public ResponseEntity<ResponseCommon<?>> findById(@PathVariable("id") String id) {
		CategoryEntity category = categoryService.findById(id);
		if(category != null) {
			CategoryResponseDto categoryDto = new CategoryResponseDto(category.getId(), category.getName(), category.getIsDeleted(), new Date(), "admin", null, null);
			return ResponseEntity.ok().body(new ResponseCommon<>(200, true, "FIND_CATEGORY_SUCCESS", categoryDto));
		}
		return ResponseEntity.badRequest().body(new ResponseCommon<>(400, false, "CATEGORY_NOT_FOUND", null));
	}
	
	@GetMapping("/category/name/{name}")
	public ResponseEntity<ResponseCommon<?>> findByName(@PathVariable("name") String name) {
		CategoryEntity category = categoryService.findByName(name);
		if(category != null) {
			CategoryResponseDto categoryDto = new CategoryResponseDto(category.getId(), category.getName(), category.getIsDeleted(), new Date(), "admin", null, null);
			return ResponseEntity.ok().body(new ResponseCommon<>(200, true, "FIND_CATEGORY_SUCCESS", categoryDto));
		}
		return ResponseEntity.badRequest().body(new ResponseCommon<>(400, false, "CATEGORY_NOT_FOUND", null));
	}
	
	@GetMapping("/category/create")
	public ResponseEntity<ResponseCommon<?>> create(@RequestParam("name") String name) {
		CreateCategoryDto createCategoryDto = new CreateCategoryDto(name);
		CategoryResponseDto categoryDto = categoryService.create(createCategoryDto);
		if(categoryDto != null) {
			return ResponseEntity.ok().body(new ResponseCommon<>(200, true, "CREATE_CATEGORY_SUCCESS", categoryDto));
		}
		return ResponseEntity.badRequest().body(new ResponseCommon<>(400, false, "CREATE_CATEGORY_FAIL", null));
	}
	
	@GetMapping("/category/update")
	public ResponseEntity<ResponseCommon<?>> update(@RequestParam("id") String id ,@RequestParam("name") String name) {
		UpdateCategoryDto updateCategoryDto = new UpdateCategoryDto(id, name);
		CategoryResponseDto categoryDto = categoryService.update(updateCategoryDto);
		if(categoryDto != null) {
			return ResponseEntity.ok().body(new ResponseCommon<>(200, true, "UPDATE_CATEGORY_SUCCESS", categoryDto));
		}
		return ResponseEntity.badRequest().body(new ResponseCommon<>(400, false, "UPDATE_CATEGORY_FAIL", null));
	}
	
	@GetMapping("/category/delete/{id}")
	public ResponseEntity<ResponseCommon<?>> delete(@PathVariable("id") String id) {
		return ResponseEntity.ok().body(new ResponseCommon<>(200, true, "DELETE_BRAND_SUCCESS", categoryService.deleteById(id)));
	}
}
