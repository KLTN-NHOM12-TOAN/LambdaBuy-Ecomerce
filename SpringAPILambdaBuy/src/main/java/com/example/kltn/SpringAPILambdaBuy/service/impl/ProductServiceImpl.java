package com.example.kltn.SpringAPILambdaBuy.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kltn.SpringAPILambdaBuy.common.request.product.CreateProductDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.product.UpdateProductDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.CategoryResponseDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ProductResponseDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.SupplierResponseDto;
import com.example.kltn.SpringAPILambdaBuy.entities.BrandEntity;
import com.example.kltn.SpringAPILambdaBuy.entities.CategoryEntity;
import com.example.kltn.SpringAPILambdaBuy.entities.ProductEntity;
import com.example.kltn.SpringAPILambdaBuy.entities.SupplierEntity;
import com.example.kltn.SpringAPILambdaBuy.repository.ProductRepository;
import com.example.kltn.SpringAPILambdaBuy.service.BrandService;
import com.example.kltn.SpringAPILambdaBuy.service.CategoryService;
import com.example.kltn.SpringAPILambdaBuy.service.ProductService;
import com.example.kltn.SpringAPILambdaBuy.service.SupplierService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private BrandService brandService;
	
	@Autowired
	private SupplierService supplierService;
	
	@Override
	public List<ProductEntity> findAll() {
		return productRepository.findAll();
	}

	@Override
	public ProductEntity findById(String id) {
		return productRepository.findById(id).isPresent()
									? productRepository.findById(id).get()
									: null;
	}
	
	@Override
	public List<ProductEntity> findContainName(String name) {
		List<ProductEntity> list = productRepository.findAll();
		List<ProductEntity> rs = new ArrayList<>();
//		List<ProductResponseDto> listDto = new ArrayList<>();
		for (ProductEntity product : list) {
			if(product.getName().contains(name)) {
				rs.add(product);
//				ProductResponseDto productDto = new ProductResponseDto(product.getId() ,product.getName(), product.getDescription(), product.getUnitPrice(), product.getDiscount(), product.getImage(), product.getInStock(), product.getManufacturedDate(), product.getCountry(), product.getSpecial(),
//						product.getCreatedDate(), product.getCreatedBy(), product.getUpdatedDate(), product.getUpdatedBy(), product.getIsDeleted());
//				listDto.add(productDto);
			}
		}
		return rs;
	}

	@Override
	public ProductResponseDto create(CreateProductDto createProductDto) {
		CategoryEntity category = categoryService.findByName(createProductDto.getCategory());
		BrandEntity brand = brandService.findByName(createProductDto.getBrand());
		SupplierEntity supplier = supplierService.findByName(createProductDto.getSupplier());
		
		ProductEntity product = new ProductEntity(createProductDto.getName(), createProductDto.getDescription(), createProductDto.getUnitPrice(), createProductDto.getDiscount(), createProductDto.getImage(), createProductDto.getInStock(), createProductDto.getManufacturedDate(), createProductDto.getCountry(), createProductDto.getIsSpecial(), new Date(), "admin", null, null, false, category, brand, supplier);
		ProductEntity createProduct = productRepository.save(product);
		if(createProduct != null) {
			ProductResponseDto productDto = new ProductResponseDto(product.getId() ,product.getName(), product.getDescription(), product.getUnitPrice(), product.getDiscount(), product.getImage(), product.getInStock(), product.getManufacturedDate(), product.getCountry(), product.getSpecial(),
					product.getCreatedDate(), product.getCreatedBy(), product.getUpdatedDate(), product.getUpdatedBy(), product.getIsDeleted(), product.getCategory().getName(), product.getBrand().getName(), product.getSupplier().getName());
			return productDto;
		}
		return null;
	}
	
	@Override
	public ProductResponseDto update(UpdateProductDto updateProductDto) {
		ProductEntity product = productRepository.findById(updateProductDto.getId()).isPresent()
								? productRepository.findById(updateProductDto.getId()).get()
								: null;
		if(product != null) {
			product.setName(updateProductDto.getName());
			product.setDescription(updateProductDto.getDescription());
			product.setUnitPrice(updateProductDto.getUnitPrice());
			product.setDiscount(updateProductDto.getDiscount());
			product.setImage(updateProductDto.getImage());
			product.setInStock(updateProductDto.getInStock());
			product.setCountry(updateProductDto.getCountry());
			product.setManufacturedDate(updateProductDto.getManufacturedDate());
			product.setSpecial(updateProductDto.getIsSpecial());
			product.setIsDeleted(updateProductDto.getIsDeleted());
			
			CategoryEntity category = categoryService.findByName(updateProductDto.getCategory());
			product.setCategory(category);
			
			BrandEntity brand = brandService.findByName(updateProductDto.getBrand());
			product.setBrand(brand);
			
			SupplierEntity supplier = supplierService.findByName(updateProductDto.getSupplier());
			product.setSupplier(supplier);
			
			ProductEntity updateProduct = productRepository.save(product);
			ProductResponseDto productDto = new ProductResponseDto(updateProduct.getId() ,updateProduct.getName(), updateProduct.getDescription(), updateProduct.getUnitPrice(), updateProduct.getDiscount(), updateProduct.getImage(), updateProduct.getInStock(), updateProduct.getManufacturedDate(), updateProduct.getCountry(), updateProduct.getSpecial(),
					updateProduct.getCreatedDate(), updateProduct.getCreatedBy(), new Date(), "admin", updateProduct.getIsDeleted(), updateProduct.getCategory().getName(), updateProduct.getBrand().getName(), updateProduct.getSupplier().getName());
			
			return productDto;
		}
		return null;
	}

	@Override
	public ProductResponseDto deleteById(String id) {
		
		ProductEntity product = productRepository.findById(id).isPresent()
								? productRepository.findById(id).get()
								: null;
		if(product != null) {
		product.setIsDeleted(true);
		ProductEntity deleteProduct = productRepository.save(product);
		ProductResponseDto productDto = new ProductResponseDto(deleteProduct.getId() ,deleteProduct.getName(), deleteProduct.getDescription(), deleteProduct.getUnitPrice(), deleteProduct.getDiscount(), deleteProduct.getImage(), deleteProduct.getInStock(), deleteProduct.getManufacturedDate(), deleteProduct.getCountry(), deleteProduct.getSpecial(),
				deleteProduct.getCreatedDate(), deleteProduct.getCreatedBy(), new Date(), "admin", deleteProduct.getIsDeleted(), deleteProduct.getCategory().getName(), deleteProduct.getBrand().getName(), deleteProduct.getSupplier().getName());
		return productDto;
		}
		return null;
	}

	@Override
	public void save(ProductEntity productEntity) {
		productRepository.save(productEntity);
	}
}
