package com.sk.sample.siren.order.application.sp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sk.sample.siren.order.domain.model.Order;
import com.sk.sample.siren.order.domain.repository.OrderRepository;
import com.sk.sample.siren.order.domain.service.OrderService;

@RestController
@RequestMapping("/v1/orders")
public class OrderRestController implements OrderService {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderRepository orderRepository;	

	@Override
	@PutMapping("/{id}/purchased")
	public void purchase(@PathVariable("id") Long id) {
		orderService.purchase(id);
	}


	@Override
	@PostMapping("/order")
	public Long order(Long accountId, Long storeId, Long productId, Integer qty) {
		Long orderId = orderService.order(accountId, storeId, productId, qty);
		orderService.purchase(orderId);
		
		return orderId;
	}
	
}