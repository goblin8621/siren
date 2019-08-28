package com.sk.sample.siren.product.domain.model;

import javax.persistence.Embeddable;

import com.sk.sample.siren.shared.base.ValueObject;

import lombok.Data;


@Data
@Embeddable
public class Money implements ValueObject {
	private Integer value;
	
	public Money(Integer value) {
		this.value = value;
	}
}

