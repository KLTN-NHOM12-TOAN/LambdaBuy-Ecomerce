package com.example.kltn.SpringAPILambdaBuy.service;

import java.util.List;

import com.example.kltn.SpringAPILambdaBuy.common.request.supplier.CreateSupplierDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.supplier.UpdateSupplierDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ResponseCommon;
import com.example.kltn.SpringAPILambdaBuy.common.response.SupplierResponseDto;
import com.example.kltn.SpringAPILambdaBuy.entities.SupplierEntity;

public interface SupplierService {
	List<SupplierEntity> findAll();
	SupplierEntity findById(String id);
	SupplierEntity findByName(String name);
	SupplierResponseDto create(CreateSupplierDto createSupplierDto);
	SupplierResponseDto update(UpdateSupplierDto updateSupplierDto);
	SupplierResponseDto deleteById(String id);
}
