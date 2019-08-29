package com.sk.sample.siren.order.domain.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.sk.sample.siren.shared.base.AbstractEntity;
import com.sk.sample.siren.shared.base.AggregateRoot;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "ordering")
public class Order extends AbstractEntity implements AggregateRoot {
	private Long accountId;
	private Long storeId;
	private Long productId;
	private Integer qty;
	
	private Boolean purchased = false;

	public Order(Long accountId, Long storeId, Long productId, Integer qty) {
		this.accountId = accountId;
		this.storeId = storeId;
		this.productId = productId;
		this.qty = qty;
	}

}
