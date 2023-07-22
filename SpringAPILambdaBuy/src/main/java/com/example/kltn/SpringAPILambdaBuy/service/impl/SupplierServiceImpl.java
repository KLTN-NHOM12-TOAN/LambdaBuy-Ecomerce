package com.example.kltn.SpringAPILambdaBuy.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kltn.SpringAPILambdaBuy.common.request.supplier.CreateSupplierDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.supplier.UpdateSupplierDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.BrandResponseDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.CategoryResponseDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ResponseCommon;
import com.example.kltn.SpringAPILambdaBuy.common.response.SupplierResponseDto;
import com.example.kltn.SpringAPILambdaBuy.entities.BrandEntity;
import com.example.kltn.SpringAPILambdaBuy.entities.SupplierEntity;
import com.example.kltn.SpringAPILambdaBuy.repository.SupplierRepository;
import com.example.kltn.SpringAPILambdaBuy.service.SupplierService;

@Service
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	private SupplierRepository supplierRepository;
	
	@Override
	public List<SupplierEntity> findAll() {
		return supplierRepository.findAll();
	}

	@Override
	public SupplierEntity findById(String id) {
		return supplierRepository.findById(id).isPresent()
				? supplierRepository.findById(id).get()
				: null;
	}

	@Override
	public SupplierEntity findByName(String name) {
		List<SupplierEntity> list = supplierRepository.findAll();
		for (SupplierEntity supplier : list) {
			if(supplier.getName().equalsIgnoreCase(name)) {
				return supplier;
			}
		}
		return null;
	}

	@Override
	public SupplierResponseDto create(CreateSupplierDto createSupplierDto) {
		SupplierEntity supplier = new SupplierEntity(createSupplierDto.getName(), createSupplierDto.getAddress(), createSupplierDto.getDescription(), new HashSet<>(), false, new Date(), null);
		List<SupplierEntity> list = supplierRepository.findAll();
		if(list.size() == 0) {
			SupplierEntity createSupplier = supplierRepository.save(supplier);
			if(createSupplier != null) {
				SupplierResponseDto supplierDto = new SupplierResponseDto(createSupplier.getId(), createSupplier.getName(), createSupplier.getAddress(), createSupplier.getDescription(), false, new Date(), "admin", null, null);
				return supplierDto;
			} else {
				return null;
			}
		}
		for (SupplierEntity supplierEntity : list) {
			if(!supplierEntity.getName().equalsIgnoreCase(createSupplierDto.getName())) {
				SupplierEntity createSupplier = supplierRepository.save(supplier);
				if(createSupplier != null) {
					SupplierResponseDto supplierDto = new SupplierResponseDto(createSupplier.getId(), createSupplier.getName(), createSupplier.getAddress(), createSupplier.getDescription(), false, new Date(), "admin", null, null);
					return supplierDto;
				} else {
					return null;
				}
			}
		}
		return null;
	}
	
	@Override
	public SupplierResponseDto update(UpdateSupplierDto updateSupplierDto) {
		SupplierEntity supplier = supplierRepository.findById(updateSupplierDto.getId()).isPresent()
									? supplierRepository.findById(updateSupplierDto.getId()).get()
									: null;
		if(supplier != null) {
			supplier.setName(updateSupplierDto.getName());
			supplier.setAddress(updateSupplierDto.getAddress());
			supplier.setDescription(updateSupplierDto.getDescription());
			supplier.setUpdatedDate(new Date());
			SupplierEntity updateSupplier = supplierRepository.save(supplier);
			SupplierResponseDto supplierDto = new SupplierResponseDto(updateSupplier.getId(), updateSupplier.getName(), updateSupplier.getAddress(), updateSupplier.getDescription(), updateSupplier.getIsDeleted(), updateSupplier.getCreatedDate(), updateSupplier.getCreatedBy(), new Date(), "admin");
			return supplierDto;
		}
		return null;
	}

	@Override
	public SupplierResponseDto deleteById(String id) {
		SupplierEntity supplier = supplierRepository.findById(id).isPresent()
								? supplierRepository.findById(id).get()
								: null;
		if(supplier != null) {
			supplier.setIsDeleted(true);
			SupplierEntity deleteSupplier = supplierRepository.save(supplier);
			SupplierResponseDto supplierDto = new SupplierResponseDto(deleteSupplier.getId(), deleteSupplier.getName(), deleteSupplier.getAddress(), deleteSupplier.getDescription(), deleteSupplier.getIsDeleted(), deleteSupplier.getCreatedDate(), deleteSupplier.getCreatedBy(), new Date(), "admin");
			return supplierDto;
		}
		return null;
	}
}
