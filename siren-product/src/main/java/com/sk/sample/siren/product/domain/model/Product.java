package com.sk.sample.siren.product.domain.model;

import javax.persistence.Entity;

import com.sk.sample.siren.shared.base.AbstractEntity;
import com.sk.sample.siren.shared.base.AggregateRoot;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Product extends AbstractEntity implements AggregateRoot {

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
