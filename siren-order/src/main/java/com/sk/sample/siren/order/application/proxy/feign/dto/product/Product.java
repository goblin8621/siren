package com.sk.sample.siren.order.application.proxy.feign.dto.product;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Product {
	
	private Long id;
	
	private Integer price;
	private Integer stock;

	private Long storeId;

	private String name;
	private String misc;

	public Product(Long storeId, String name,Integer price, Integer stock) {
		this.storeId = storeId;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}
	
}

