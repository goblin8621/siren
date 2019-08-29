package com.sk.sample.siren.store.domain.model;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.sk.sample.siren.shared.base.ValueObject;

import lombok.Data;

@Embeddable
@Data
public class StoreDescription implements ValueObject {
	@Enumerated(EnumType.STRING)
	private StoreType storeType;
	
	private String storeInfo;

	public StoreDescription(StoreType storeType, String storeInfo) {
		this.storeType = storeType;
		this.storeInfo = storeInfo;
	}
}

