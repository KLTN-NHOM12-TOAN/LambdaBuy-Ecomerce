package com.example.kltn.SpringAPILambdaBuy.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.example.kltn.SpringAPILambdaBuy.common.request.product.CreateProductDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.product.UpdateProductDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ProductResponseDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ResponseCommon;
import com.example.kltn.SpringAPILambdaBuy.common.response.SupplierResponseDto;
import com.example.kltn.SpringAPILambdaBuy.entities.ProductEntity;
import com.example.kltn.SpringAPILambdaBuy.entities.SupplierEntity;
import com.example.kltn.SpringAPILambdaBuy.service.ProductService;

@RestController
@RequestMapping("")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public ResponseEntity<ResponseCommon<?>> findAll(){
		List<ProductEntity> list = productService.findAll();
		List<ProductResponseDto> listDto = new ArrayList<>();
		for (ProductEntity product : list) {
			ProductResponseDto productDto = new ProductResponseDto(product.getId() ,product.getName(), product.getDescription(), product.getUnitPrice(), product.getDiscount(), product.getImage(), product.getInStock(), product.getManufacturedDate(), product.getCountry(), product.getSpecial(),
					product.getCreatedDate(), product.getCreatedBy(), product.getCreatedDate(), product.getCreatedBy(), product.getIsDeleted(), product.getCategory().getName(), product.getBrand().getName(), product.getSupplier().getName());
			listDto.add(productDto);
		}
		return ResponseEntity.ok().body(new ResponseCommon<>(200, true, "FIND_ALL_PRODUCT_SUCCESS", listDto));
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<ResponseCommon<?>> findById(@PathVariable("id") String id) {
		ProductEntity product = productService.findById(id);
		if(product != null) {
			ProductResponseDto productDto = new ProductResponseDto(product.getId() ,product.getName(), product.getDescription(), product.getUnitPrice(), product.getDiscount(), product.getImage(), product.getInStock(), product.getManufacturedDate(), product.getCountry(), product.getSpecial(),
					product.getCreatedDate(), product.getCreatedBy(), product.getUpdatedDate(), product.getUpdatedBy(), product.getIsDeleted(), product.getCategory().getName(), product.getBrand().getName(), product.getSupplier().getName());
			return ResponseEntity.ok().body(new ResponseCommon<>(200, true, "FIND_PRODUCT_SUCCESS", productDto));
		}
		return ResponseEntity.badRequest().body(new ResponseCommon<>(400, false, "PRODUCT_NOT_FOUND", null));
	
	}
	
	@GetMapping("/product/entity/{id}")
	public ResponseEntity<ResponseCommon<?>> findProductById(@PathVariable("id") String id) {
		ProductEntity product = productService.findById(id);
		if(product != null) {
			return ResponseEntity.ok().body(new ResponseCommon<>(200, true, "FIND_PRODUCT_SUCCESS", product));
		}
		return ResponseEntity.badRequest().body(new ResponseCommon<>(400, false, "PRODUCT_NOT_FOUND", null));
	
	}
	
	@GetMapping("/product/name/{name}")
	public ResponseEntity<ResponseCommon<?>> findContainName(@PathVariable("name") String name) {
		List<ProductEntity> listProduct = productService.findContainName(name);
		List<ProductResponseDto> listDto = new ArrayList<>();
		for (ProductEntity product : listProduct) {
			ProductResponseDto productDto = new ProductResponseDto(product.getId() ,product.getName(), product.getDescription(), product.getUnitPrice(), product.getDiscount(), product.getImage(), product.getInStock(), product.getManufacturedDate(), product.getCountry(), product.getSpecial(),
					product.getCreatedDate(), product.getCreatedBy(), product.getCreatedDate(), product.getCreatedBy(), product.getIsDeleted(), product.getCategory().getName(), product.getBrand().getName(), product.getSupplier().getName());
			listDto.add(productDto);
		}
		return ResponseEntity.ok().body(new ResponseCommon<>(200, true, "FIND_ALL_PRODUCT_SUCCESS", listDto));
	}
	
	@PostMapping("/product/create")
	public ResponseEntity<ResponseCommon<?>> create(CreateProductDto createProductDto) {
		ProductResponseDto productDto = productService.create(createProductDto);
		if(productDto != null) {
			return ResponseEntity.ok().body(new ResponseCommon<>(200, true, "CREATE_PRODUCT_SUCCESS", productDto));
		}
		return ResponseEntity.badRequest().body(new ResponseCommon<>(400, false, "CREATE_PRODUCT_FAIL", null));
	}
	
	@PostMapping("/product/update")
	public ResponseEntity<ResponseCommon<?>> update(UpdateProductDto updateProductDto){
		ProductResponseDto productDto = productService.update(updateProductDto);
		if(productDto != null) {
			return ResponseEntity.ok().body(new ResponseCommon<>(200, true, "UPDATE_PRODUCT_SUCCESS", productDto));
		}
		return ResponseEntity.badRequest().body(new ResponseCommon<>(400, false, "UPDATE_PRODUCT_FAIL", null));
	}
	
	@GetMapping("/product/delete/{id}")
	public ResponseEntity<ResponseCommon<?>> delete(@PathVariable String id) {
		return ResponseEntity.ok().body(new ResponseCommon<>(200, true, "DELETE_PRODUCT_SUCCESS", productService.deleteById(id)));
	}
	
	
	
	
}
