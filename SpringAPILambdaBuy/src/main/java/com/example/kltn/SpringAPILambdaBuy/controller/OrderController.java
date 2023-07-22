package com.example.kltn.SpringAPILambdaBuy.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.kltn.SpringAPILambdaBuy.common.request.order.CreateOrderDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.OrderResponseDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ResponseCommon;
import com.example.kltn.SpringAPILambdaBuy.entities.OrderEntity;
import com.example.kltn.SpringAPILambdaBuy.service.OrderService;
import com.example.kltn.SpringAPILambdaBuy.service.ProductService;

@RestController
@RequestMapping("")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private HttpSession session;
	
	@GetMapping("/order/{id}")
	public ResponseEntity<ResponseCommon<?>> findById(@PathVariable("id") String id) {
		OrderEntity order = orderService.findById(id);
//		List<ProductEntity> listProduct = order.getListProduct();
//		List<ProductResponseDto> listProductDto = new ArrayList<>();
//		for (ProductEntity product : listProduct) {
//			ProductResponseDto productDto = new ProductResponseDto(product.getId() ,product.getName(), product.getDescription(), product.getUnitPrice(), product.getDiscount(), product.getImage(), product.getInStock(), product.getManufacturedDate(), product.getCountry(), product.getSpecial(),
//					product.getCreatedDate(), product.getCreatedBy(), product.getUpdatedDate(), product.getUpdatedBy(), product.getIsDeleted(), product.getCategory().getName(), product.getBrand().getName(), product.getSupplier().getName());
//			listProductDto.add(productDto);
//		}
		
		if(order != null) {
			OrderResponseDto orderDto = new OrderResponseDto(order.getId(), order.getSubTotal(), order.getShipping(), order.getTax(), order.getTotal());
			return ResponseEntity.ok().body(new ResponseCommon<>(200, true, "FIND_ORDER_SUCCESS", orderDto));
		}
		return ResponseEntity.badRequest().body(new ResponseCommon<>(400, false, "ORDER_NOT_FOUND", null));
	}
	
	@GetMapping("/order/entity/{id}")
	public ResponseEntity<ResponseCommon<?>> findOrderEntityById(@PathVariable("id") String id) {
		OrderEntity order = orderService.findById(id);
//		List<ProductEntity> listProduct = order.getListProduct();
//		List<ProductResponseDto> listProductDto = new ArrayList<>();
//		for (ProductEntity product : listProduct) {
//			ProductResponseDto productDto = new ProductResponseDto(product.getId() ,product.getName(), product.getDescription(), product.getUnitPrice(), product.getDiscount(), product.getImage(), product.getInStock(), product.getManufacturedDate(), product.getCountry(), product.getSpecial(),
//					product.getCreatedDate(), product.getCreatedBy(), product.getUpdatedDate(), product.getUpdatedBy(), product.getIsDeleted(), product.getCategory().getName(), product.getBrand().getName(), product.getSupplier().getName());
//			listProductDto.add(productDto);
//		}
		
		if(order != null) {
			return ResponseEntity.ok().body(new ResponseCommon<>(200, true, "FIND_ORDER_SUCCESS", order));
		}
		return ResponseEntity.badRequest().body(new ResponseCommon<>(400, false, "ORDER_NOT_FOUND", null));
	}
	
	@GetMapping("/order/create")
	public ResponseEntity<ResponseCommon<?>> createOrder(@RequestParam("subTotal") String subTotal, @RequestParam("shipping") String shipping, @RequestParam("tax") String tax, @RequestParam("total") String total) {
//		String[] listId = listProductId.substring(0, listProductId.length() - 2).split(", ");
		CreateOrderDto createOrderDto = new CreateOrderDto(Double.parseDouble(subTotal), Double.parseDouble(shipping), Double.parseDouble(tax), Double.parseDouble(total));
		OrderResponseDto orderResponseDto = orderService.create(createOrderDto);
		if(orderResponseDto != null) {
			return ResponseEntity.ok().body(new ResponseCommon<>(200, true, "CREATE_ORDER_SUCCESS", orderResponseDto));
		}
		return ResponseEntity.badRequest().body(new ResponseCommon<>(400, false, "CREATE_ORDER_FAIL", null));
	}
	
//	@PostMapping("/order/checkout")
//	public String purchase(@ModelAttribute("order") Order order){
//		Collection<ProductEntity> list = cartItemService.getItems();
//		List<OrderDetail> details = new  ArrayList<>();
//		List<ProductEntity> listProduct = productService.findAll();
//		for(ProductEntity product : list) {
//			OrderDetail detail =new OrderDetail();
//			detail.setOrder(order);
//			detail.setProduct(product);
//			detail.setUnitPrice(product.getUnitPrice());
//			detail.setQuantity(product.getInStock());
//			detail.setDiscount(product.getDiscount());
//			details.add(detail);
//			/*
//			 * for(Product updateProduct:listProduct) { Product productUpdate = new
//			 * Product(); productUpdate.setId(product.getId());
//			 * productUpdate.setQuantity(updateProduct.getQuantity()-product.getQuantity());
//			 * pdao.update(productUpdate); }
//			 */
//			
//		}
//		dao.create(order, details);
//		cart.clear();
//		model.addAttribute("message", "Đặt hàng thành công!");
//
//		
//		return "redirect:/order/list";
//
//	}
	
}
