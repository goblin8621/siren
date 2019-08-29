package com.sk.sample.siren.order.domain.service;

public interface OrderService {
	
	void purchase(Long orderId);
	
	Long order(Long accountId, Long productId, Integer qty);
	
}
