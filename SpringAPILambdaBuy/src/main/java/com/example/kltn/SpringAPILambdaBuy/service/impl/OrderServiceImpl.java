package com.example.kltn.SpringAPILambdaBuy.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.kltn.SpringAPILambdaBuy.common.request.order.CreateOrderDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.OrderResponseDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ProductResponseDto;
import com.example.kltn.SpringAPILambdaBuy.entities.OrderEntity;
import com.example.kltn.SpringAPILambdaBuy.entities.ProductEntity;
import com.example.kltn.SpringAPILambdaBuy.repository.OrderRepository;
import com.example.kltn.SpringAPILambdaBuy.service.OrderService;
import com.example.kltn.SpringAPILambdaBuy.service.ProductService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	@Autowired
	public OrderRepository orderRepository;
	
	@Autowired
	public ProductService productService;
	
	@Override
	public OrderResponseDto create(CreateOrderDto createOrderDto) {
//		List<String> listProductId = createOrderDto.getListProductId();
//		List<ProductEntity> listProduct = new ArrayList<>();
//		for (String productId : listProductId) {
//			ProductEntity product = productService.findById(productId);
//			if(product != null) {
//				listProduct.add(product);
//			}
//		}
//		
//		List<ProductResponseDto> listProductDto = new ArrayList<>();
//		for (ProductEntity product : listProduct) {
//			ProductResponseDto productDto = new ProductResponseDto(product.getId() ,product.getName(), product.getDescription(), product.getUnitPrice(), product.getDiscount(), product.getImage(), product.getInStock(), product.getManufacturedDate(), product.getCountry(), product.getSpecial(),
//					product.getCreatedDate(), product.getCreatedBy(), product.getUpdatedDate(), product.getUpdatedBy(), product.getIsDeleted(), product.getCategory().getName(), product.getBrand().getName(), product.getSupplier().getName());
//			listProductDto.add(productDto);
//		}
		
		OrderEntity order = new OrderEntity(createOrderDto.getSubTotal(), createOrderDto.getShipping(), createOrderDto.getTax(), createOrderDto.getTotal());
		OrderEntity createOrder = orderRepository.save(order);
		OrderResponseDto orderDto = new OrderResponseDto(createOrder.getId(), createOrder.getSubTotal(), createOrder.getShipping(), createOrder.getTax(), createOrder.getTotal());
		return orderDto;
	}

	@Override
	public OrderEntity findById(String id) {
		OrderEntity findOrder = orderRepository.findById(id).isPresent()
					? orderRepository.findById(id).get()
					: null;
		return findOrder;
	}
}
