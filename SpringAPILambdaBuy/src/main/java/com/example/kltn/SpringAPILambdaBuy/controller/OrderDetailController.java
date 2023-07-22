package com.example.kltn.SpringAPILambdaBuy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.kltn.SpringAPILambdaBuy.common.response.OrderDetailResponseDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ResponseCommon;
import com.example.kltn.SpringAPILambdaBuy.entities.OrderDetailEntity;
import com.example.kltn.SpringAPILambdaBuy.entities.OrderEntity;
import com.example.kltn.SpringAPILambdaBuy.entities.ProductEntity;
import com.example.kltn.SpringAPILambdaBuy.service.OrderDetailService;
import com.example.kltn.SpringAPILambdaBuy.service.OrderService;
import com.example.kltn.SpringAPILambdaBuy.service.ProductService;

@RestController
@RequestMapping("/orderdetail")
public class OrderDetailController {
	@Autowired
	private OrderDetailService orderDetailService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseCommon<?>> findById(@PathVariable("id") String id){
		OrderDetailEntity order = orderDetailService.findById(id);
		if(order != null) {
			OrderDetailResponseDto orderDto = new OrderDetailResponseDto(order.getId(), order.getDescription(), order.getOrder().getSubTotal(), order.getOrder().getShipping(), order.getOrder().getTax(), order.getOrder().getTotal(), order.getPayerFirtName(), order.getPayerLastName(), order.getPayerEmail(), order.getRecidentName(), order.getShippingLine1(), order.getShippingCity(), order.getShippingCountryCode(), order.getShippingPostalCode());
			return ResponseEntity.ok().body(new ResponseCommon<>(200, true, "FIND_ORDER_DETAIL_SUCCESS", orderDto));
		}
		return ResponseEntity.badRequest().body(new ResponseCommon<>(400, false, "ORDER_DETAIL_NOT_FOUND", null));
	}
	
	@GetMapping("/create")
	public ResponseEntity<ResponseCommon<?>> create(@RequestParam("orderId") String orderId, @RequestParam("productId") String productId, @RequestParam("description") String description, @RequestParam("payerFirstName") String payerFirstName, @RequestParam("payerLastName") String payerLastName, @RequestParam("payerEmail") String payerEmail, @RequestParam("recidentName") String recidentName, @RequestParam("shippingLine1") String shippingLine1, @RequestParam("shippingCity") String shippingCity, @RequestParam("shippingCountryCode") String shippingCountryCode, @RequestParam("shippingPostalCode") String shippingPostalCode) {
		OrderEntity order = orderService.findById(orderId);
		ProductEntity product = productService.findById(productId);
		
		OrderDetailEntity orderdetail = new OrderDetailEntity(product, order, description, payerFirstName, payerLastName, payerEmail, recidentName, shippingLine1, shippingCity, shippingCountryCode, Double.parseDouble(shippingPostalCode));
		OrderDetailResponseDto orderdetailDto = orderDetailService.create(orderdetail);
		if(orderdetailDto != null) {
			return ResponseEntity.ok().body(new ResponseCommon<>(200, true, "CREATE_ORDER_DETAIL_SUCCESS", orderdetailDto));
		}
		return ResponseEntity.badRequest().body(new ResponseCommon<>(400, false, "CREATE_ORDER_DETAIL_FAIL", null));
	}
}
