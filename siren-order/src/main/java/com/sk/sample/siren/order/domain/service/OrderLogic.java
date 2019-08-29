package com.sk.sample.siren.order.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sk.sample.siren.order.application.proxy.feign.ProductProxy;
import com.sk.sample.siren.order.application.proxy.feign.dto.product.Product;
import com.sk.sample.siren.order.domain.model.Order;
import com.sk.sample.siren.order.domain.repository.OrderRepository;

@Service("orderLogic")
public class OrderLogic implements OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductProxy productProxy;
	
	public void purchase(Long orderId) {
		System.out.println("purchase start ******************************************");
		
		Order order = orderRepository.findOne(orderId);
	
		if (order == null) {
			System.err.println("no order");
			return;
		}
		
		System.out.println("order: " + order);

		if (order.getPurchased() == true) {
			System.err.println("already purchased");
			return;
		}

		Product product = productProxy.findProduct(order.getProductId());
		
		System.out.println("product info1 ******************************************");
		System.out.println(product);
		
		if (product.getStock() <= 0) {
			System.err.println("have no stock err");
			return;
		}
		
		product.setStock( product.getStock() - order.getQty() );
		productProxy.productsUpdate(product.getId(), product);
		
		System.out.println("product info2 ******************************************");
		System.out.println(product);		
		
		order.setPurchased(true);
		orderRepository.save(order);
		
		System.out.println("order info ******************************************");
		System.out.println(order);
	}
	
}
