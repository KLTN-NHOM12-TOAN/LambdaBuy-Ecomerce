package com.example.kltn.SpringAPILambdaBuy.service;

import com.example.kltn.SpringAPILambdaBuy.common.request.order.CreateOrderDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.OrderResponseDto;
import com.example.kltn.SpringAPILambdaBuy.entities.OrderEntity;

public interface OrderService {
	OrderEntity findById(String id);
	OrderResponseDto create(CreateOrderDto createOrderDto);
}
