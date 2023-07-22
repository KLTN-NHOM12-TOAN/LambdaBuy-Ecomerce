package com.example.kltn.SpringAPILambdaBuy.service;

import java.util.List;

import com.example.kltn.SpringAPILambdaBuy.common.request.product.CreateProductDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.product.UpdateProductDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ProductResponseDto;
import com.example.kltn.SpringAPILambdaBuy.entities.ProductEntity;


public interface ProductService {
	public List<ProductEntity> findAll();
	public ProductEntity findById(String id);
	public List<ProductEntity> findContainName(String name);
	public void save(ProductEntity productEntity);
	public ProductResponseDto create(CreateProductDto createProductDto);
	public ProductResponseDto update(UpdateProductDto updateProductDto);
	public ProductResponseDto deleteById(String id);
}
