package com.example.kltn.SpringAPILambdaBuy.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kltn.SpringAPILambdaBuy.common.request.brand.CreateBrandDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.brand.UpdateBrandDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.BrandResponseDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.SupplierResponseDto;
import com.example.kltn.SpringAPILambdaBuy.entities.BrandEntity;
import com.example.kltn.SpringAPILambdaBuy.entities.SupplierEntity;
import com.example.kltn.SpringAPILambdaBuy.repository.BrandRepository;
import com.example.kltn.SpringAPILambdaBuy.service.BrandService;

@Service
@Transactional
public class BrandServiceImpl implements BrandService {
	@Autowired
	private BrandRepository brandRepository;
	
	@Override
	public List<BrandEntity> findAll() {
		return brandRepository.findAll();
	}

	@Override
	public BrandEntity findById(String id) {
		return brandRepository.findById(id).isPresent() 
							? brandRepository.findById(id).get()
							: null;
	}
	
	@Override
	public BrandEntity findByName(String name) {
		List<BrandEntity> list = brandRepository.findAll();
		for (BrandEntity brand : list) {
			if(brand.getName().equalsIgnoreCase(name)) {
				return brand;
			}
		}
		return null;
	}
	
	@Override
	public void save(BrandEntity brand) {
		brandRepository.save(brand);
	}

	@Override
	public BrandResponseDto create(CreateBrandDto createBrandDto) {
		BrandEntity brand = new BrandEntity(createBrandDto.getName(), createBrandDto.getFullName(), createBrandDto.getAddress(), new HashSet<>(), false, new Date(), "admin", null, null);
		List<BrandEntity> list = brandRepository.findAll();
		if(list.size() == 0) {
			BrandEntity createBrand = brandRepository.save(brand);
			if(createBrand != null) {
				BrandResponseDto brandDto = new BrandResponseDto(createBrand.getId(), createBrand.getName(), createBrand.getFullName(), createBrand.getAddress(), createBrand.getIsDeleted(), createBrand.getCreatedDate(), createBrand.getCreatedBy(), createBrand.getUpdatedDate(), createBrand.getUpdatedBy());
				return brandDto;
			} else {
				return null;
			}
		}
		for (BrandEntity brandEntity : list) {
			if(!brandEntity.getName().equalsIgnoreCase(createBrandDto.getName())) {
				BrandEntity createBrand = brandRepository.save(brand);
				if(createBrand != null) {
					BrandResponseDto brandDto = new BrandResponseDto(createBrand.getId(), createBrand.getName(), createBrand.getFullName(), createBrand.getAddress(), createBrand.getIsDeleted(), createBrand.getCreatedDate(), createBrand.getCreatedBy(), createBrand.getUpdatedDate(), createBrand.getUpdatedBy());
					return brandDto;
				} else {
					return null;
				}
			}
		}
		return null;
	}

	@Override
	public BrandResponseDto update(UpdateBrandDto updateBrandDto) {
		BrandEntity brand = brandRepository.findById(updateBrandDto.getId()).isPresent()
								? brandRepository.findById(updateBrandDto.getId()).get()
								: null;
		if(brand != null) {
			brand.setName(updateBrandDto.getName());
			brand.setFullName(updateBrandDto.getFullName());
			brand.setAddress(updateBrandDto.getAddress());
			brand.setIsDeleted(updateBrandDto.getIsDeleted());
			brand.setListProduct(brand.getListProduct());
			brand.setUpdatedDate(new Date());
			BrandEntity updateBrand = brandRepository.save(brand);
			BrandResponseDto brandDto = new BrandResponseDto(updateBrand.getId(), updateBrand.getName(), updateBrand.getFullName(), updateBrand.getAddress(), updateBrand.getIsDeleted(), brand.getCreatedDate(), brand.getCreatedBy(), new Date(), "admin");
			return brandDto;
		}
		return null;
	}

	@Override
	public BrandResponseDto deleteById(String id) {
		BrandEntity brand = brandRepository.findById(id).isPresent()
				? brandRepository.findById(id).get()
				: null;
		if(brand != null) {
			brand.setIsDeleted(true);
			BrandEntity deleteBrand = brandRepository.save(brand);
			BrandResponseDto brandDto = new BrandResponseDto(deleteBrand.getId(), deleteBrand.getName(), deleteBrand.getFullName(), deleteBrand.getAddress(), deleteBrand.getIsDeleted(), deleteBrand.getCreatedDate(), deleteBrand.getCreatedBy(), deleteBrand.getUpdatedDate(), deleteBrand.getUpdatedBy());
			return brandDto;
		}
		return null;
	}

}
