package com.sk.sample.siren.order.application.sp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sk.sample.siren.order.domain.service.OrderService;

@RestController
@RequestMapping("/v1/orders")
public class OrderRestController implements OrderService {
	
	@Autowired
	private OrderService orderService;
	
	@Override
	@PutMapping("/{id}/purchased")
	public void purchase(@PathVariable("id") Long id) {
		orderService.purchase(id);
	}

	@Override
	@PostMapping("/order")
	public Long order(Long accountId, Long productId, Integer qty) {
		Long orderId = orderService.order(accountId, productId, qty);
		orderService.purchase(orderId);
		
		return orderId;
	}
	
}