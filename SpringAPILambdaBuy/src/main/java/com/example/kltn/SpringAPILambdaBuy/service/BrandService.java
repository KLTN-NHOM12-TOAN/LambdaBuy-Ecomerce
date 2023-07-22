package com.example.kltn.SpringAPILambdaBuy.service;

import java.util.List;

import com.example.kltn.SpringAPILambdaBuy.common.request.brand.CreateBrandDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.brand.UpdateBrandDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.BrandResponseDto;
import com.example.kltn.SpringAPILambdaBuy.entities.BrandEntity;

public interface BrandService {
	public List<BrandEntity> findAll();
	public BrandEntity findById(String id);
	public BrandEntity findByName(String name);
	public void save(BrandEntity brand);
	public BrandResponseDto create(CreateBrandDto createBrandDto);
	public BrandResponseDto update(UpdateBrandDto updateBrandDto);
	BrandResponseDto deleteById(String id);
}
