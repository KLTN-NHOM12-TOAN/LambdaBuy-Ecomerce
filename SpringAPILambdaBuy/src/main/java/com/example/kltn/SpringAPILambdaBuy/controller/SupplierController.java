package com.example.kltn.SpringAPILambdaBuy.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.kltn.SpringAPILambdaBuy.common.request.supplier.CreateSupplierDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.supplier.UpdateSupplierDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.CategoryResponseDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ResponseCommon;
import com.example.kltn.SpringAPILambdaBuy.common.response.SupplierResponseDto;
import com.example.kltn.SpringAPILambdaBuy.entities.CategoryEntity;
import com.example.kltn.SpringAPILambdaBuy.entities.SupplierEntity;
import com.example.kltn.SpringAPILambdaBuy.service.SupplierService;

@RestController
@RequestMapping("")
public class SupplierController {
	@Autowired
	private SupplierService supplierService;
	
	@GetMapping("/suppliers")
	public ResponseEntity<ResponseCommon<?>> findAll() {
		List<SupplierEntity> list = supplierService.findAll();
		List<SupplierResponseDto> listDto = new ArrayList<>();
		for (SupplierEntity supplier : list) {
			SupplierResponseDto supplierDto = new SupplierResponseDto(supplier.getId(), supplier.getName(), supplier.getAddress(), supplier.getDescription(), supplier.getIsDeleted(), supplier.getCreatedDate(), supplier.getCreatedBy(), supplier.getUpdatedDate(), supplier.getUpdatedBy());
			listDto.add(supplierDto);
		}
		return ResponseEntity.ok().body(new ResponseCommon<>(200, true, "FIND_ALL_SUPPLIER_SUCCESS", listDto));
	}
	
	@GetMapping("/supplier/{id}")
	public ResponseEntity<ResponseCommon<?>> findById(@PathVariable("id") String id){
		SupplierEntity supplier = supplierService.findById(id);
		if(supplier != null) {
			SupplierResponseDto supplierDto = new SupplierResponseDto(supplier.getId(), supplier.getName(), supplier.getAddress(), supplier.getDescription(), supplier.getIsDeleted(), supplier.getCreatedDate(), supplier.getCreatedBy(), supplier.getUpdatedDate(), supplier.getUpdatedBy());
			return ResponseEntity.ok().body(new ResponseCommon<>(200, true, "FIND_SUPPLIER_SUCCESS", supplierDto));
		}
		return ResponseEntity.badRequest().body(new ResponseCommon<>(400, false, "SUPPLIER_NOT_FOUND", null));
	
	}
	
	@GetMapping("/supplier/name/{name}")
	public ResponseEntity<ResponseCommon<?>> findByName(@PathVariable("name") String name){
		SupplierEntity supplier = supplierService.findByName(name);
		if(supplier != null) {
			SupplierResponseDto supplierDto = new SupplierResponseDto(supplier.getId(), supplier.getName(), supplier.getAddress(), supplier.getDescription(), supplier.getIsDeleted(), supplier.getCreatedDate(), supplier.getCreatedBy(), supplier.getUpdatedDate(), supplier.getUpdatedBy());
			return ResponseEntity.ok().body(new ResponseCommon<>(200, true, "FIND_SUPPLIER_SUCCESS", supplierDto));
		}
		return ResponseEntity.badRequest().body(new ResponseCommon<>(400, false, "SUPPLIER_NOT_FOUND", null));
	}
	
	@GetMapping("/supplier/create")
	public ResponseEntity<ResponseCommon<?>> createSupplier(@RequestParam("name") String name, @RequestParam("address") String address, @RequestParam("description") String description) {
		CreateSupplierDto createSupplierDto = new CreateSupplierDto(name, address, description);
		SupplierResponseDto supplierDto = supplierService.create(createSupplierDto);
		if(supplierDto != null) {
			return ResponseEntity.ok().body(new ResponseCommon<>(200, true, "CREATE_SUPPLIER_SUCCESS", supplierDto));
		}
		return ResponseEntity.badRequest().body(new ResponseCommon<>(400, false, "CREATE_SUPPLIER_FAIL", null));
	}
	
	@GetMapping("/supplier/update")
	public ResponseEntity<ResponseCommon<?>> updateSupplier(@RequestParam("id") String id ,@RequestParam("name") String name, @RequestParam("address") String address, @RequestParam("description") String description) {
		UpdateSupplierDto updateSupplierDto = new UpdateSupplierDto(id, name, address, description);
		SupplierResponseDto supplierDto = supplierService.update(updateSupplierDto);
		if(supplierDto != null) {
			return ResponseEntity.ok().body(new ResponseCommon<>(200, true, "UPDATE_SUPPLIER_SUCCESS", supplierDto));
		}
		return ResponseEntity.badRequest().body(new ResponseCommon<>(400, false, "UPDATE_SUPPLIER_FAIL", null));
	}
	
	@GetMapping("/supplier/delete/{id}")
	public ResponseEntity<ResponseCommon<?>> deleteSupplier(@PathVariable("id") String id) {
		return ResponseEntity.ok().body(new ResponseCommon<>(200, true, "DELETE_SUPPLIER_SUCCESS", supplierService.deleteById(id)));
	}
}
