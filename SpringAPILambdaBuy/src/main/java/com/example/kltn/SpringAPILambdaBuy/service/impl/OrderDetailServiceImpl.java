package com.example.kltn.SpringAPILambdaBuy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kltn.SpringAPILambdaBuy.common.response.OrderDetailResponseDto;
import com.example.kltn.SpringAPILambdaBuy.entities.OrderDetailEntity;
import com.example.kltn.SpringAPILambdaBuy.repository.OrderDetailRepository;
import com.example.kltn.SpringAPILambdaBuy.service.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
	@Autowired
	private OrderDetailRepository orderDetailRepository;

	@Override
	public OrderDetailEntity findById(String id) {
		return orderDetailRepository.findById(id).isPresent()
					? orderDetailRepository.findById(id).get()
					: null;
	}

	@Override
	public OrderDetailResponseDto create(OrderDetailEntity order) {
		OrderDetailEntity createOrder = orderDetailRepository.save(order);
		if(createOrder != null) {
			OrderDetailResponseDto orderDto = new OrderDetailResponseDto(createOrder.getId(), createOrder.getDescription(), createOrder.getOrder().getSubTotal(), createOrder.getOrder().getShipping(), createOrder.getOrder().getTax(), createOrder.getOrder().getTotal(), createOrder.getPayerFirtName(), createOrder.getPayerLastName(), createOrder.getPayerEmail(), createOrder.getRecidentName(), createOrder.getShippingLine1(), createOrder.getShippingCity(), createOrder.getShippingCountryCode(), createOrder.getShippingPostalCode());
			return orderDto;
		}
		return null;
	}
	
	
}
