package com.example.kltn.SpringAPILambdaBuy.service;

import com.example.kltn.SpringAPILambdaBuy.common.response.OrderDetailResponseDto;
import com.example.kltn.SpringAPILambdaBuy.entities.OrderDetailEntity;


public interface OrderDetailService {
	OrderDetailEntity findById(String id);
	OrderDetailResponseDto create(OrderDetailEntity orderDetailEntity);
}
