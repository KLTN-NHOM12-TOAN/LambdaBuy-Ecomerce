package com.example.kltn.SpringAPILambdaBuy.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kltn.SpringAPILambdaBuy.common.request.brand.CreateBrandDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.brand.UpdateBrandDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.category.CreateCategoryDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.category.UpdateCategoryDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.BrandResponseDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.CategoryResponseDto;
import com.example.kltn.SpringAPILambdaBuy.entities.BrandEntity;
import com.example.kltn.SpringAPILambdaBuy.entities.CategoryEntity;
import com.example.kltn.SpringAPILambdaBuy.repository.BrandRepository;
import com.example.kltn.SpringAPILambdaBuy.repository.CategoryRepository;
import com.example.kltn.SpringAPILambdaBuy.service.BrandService;
import com.example.kltn.SpringAPILambdaBuy.service.CategoryService;
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<CategoryEntity> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public CategoryEntity findById(String id) {
		return categoryRepository.findById(id).isPresent() 
							? categoryRepository.findById(id).get()
							: null;
	}
	
	@Override
	public CategoryEntity findByName(String name) {
		List<CategoryEntity> list = categoryRepository.findAll();
		for (CategoryEntity category : list) {
			if(category.getName().equalsIgnoreCase(name)) {
				return category;
			}
		}
		return null;
	}
	
	@Override
	public CategoryResponseDto create(CreateCategoryDto createCategoryDto) {
		CategoryEntity category = new CategoryEntity(createCategoryDto.getName(), new HashSet<>(), false, new Date(), "admin", null, null);
		List<CategoryEntity> list = categoryRepository.findAll();
		if(list.size() == 0) {
			CategoryEntity createCategory = categoryRepository.save(category);
			if(createCategory != null) {
				CategoryResponseDto categoryDto = new CategoryResponseDto(category.getId(), category.getName(), category.getIsDeleted(), category.getCreatedDate(), category.getCreatedBy(), category.getUpdatedDate(), category.getUpdatedBy());
				return categoryDto;
			} else {
				return null;
			}
		}
		for (CategoryEntity categoryEntity : list) {
			if(!categoryEntity.getName().equalsIgnoreCase(createCategoryDto.getName())) {
				CategoryEntity createCategory = categoryRepository.save(category);
				if(createCategory != null) {
					CategoryResponseDto categoryDto = new CategoryResponseDto(category.getId(), category.getName(), category.getIsDeleted(), category.getCreatedDate(), category.getCreatedBy(), category.getUpdatedDate(), category.getUpdatedBy());
					return categoryDto;
				} else {
					return null;
				}
			}
		}
		return null;
	}

	@Override
	public CategoryResponseDto update(UpdateCategoryDto updateCategoryDto) {
		CategoryEntity category = categoryRepository.findById(updateCategoryDto.getId()).isPresent()
								? categoryRepository.findById(updateCategoryDto.getId()).get()
								: null;
		if(category != null) {
			category.setName(updateCategoryDto.getName());
			category.setListProduct(category.getListProduct());
			category.setIsDeleted(category.getIsDeleted());
			category.setCreatedDate(category.getCreatedDate());;
			category.setCreatedBy(category.getCreatedBy());
			category.setUpdatedDate(new Date());
			category.setUpdatedBy("admin");
			CategoryEntity updateCategory = categoryRepository.save(category);
			CategoryResponseDto categoryDto = new CategoryResponseDto(updateCategory.getId(), updateCategory.getName(), updateCategory.getIsDeleted(), updateCategory.getCreatedDate(), updateCategory.getCreatedBy(), updateCategory.getUpdatedDate(), updateCategory.getUpdatedBy());
			return categoryDto;
		}
		return null;
	}

	@Override
	public CategoryResponseDto deleteById(String id) {
		CategoryEntity category = categoryRepository.findById(id).isPresent()
				? categoryRepository.findById(id).get()
				: null;
		if(category != null) {
			category.setIsDeleted(true);
			CategoryEntity deleteCategory = categoryRepository.save(category);
			CategoryResponseDto categoryDto = new CategoryResponseDto(deleteCategory.getId(), deleteCategory.getName(), deleteCategory.getIsDeleted(), deleteCategory.getCreatedDate(), deleteCategory.getCreatedBy(), new Date(), "admin");
			return categoryDto;
		}
		return null;
	}
}
