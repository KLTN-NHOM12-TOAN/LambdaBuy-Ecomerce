package com.example.kltn.SpringAPILambdaBuy.service;

import java.util.List;

import com.example.kltn.SpringAPILambdaBuy.common.request.category.CreateCategoryDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.category.UpdateCategoryDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.CategoryResponseDto;
import com.example.kltn.SpringAPILambdaBuy.entities.CategoryEntity;

public interface CategoryService {
	public List<CategoryEntity> findAll();
	public CategoryEntity findById(String id);
	public CategoryEntity findByName(String name);
	public CategoryResponseDto create(CreateCategoryDto createCategoryDto);
	public CategoryResponseDto update(UpdateCategoryDto updateCategoryDto);
	CategoryResponseDto deleteById(String id);
}
