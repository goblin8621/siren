package com.sk.sample.siren.store.domain.model;

import javax.persistence.Entity;

import com.sk.sample.siren.shared.base.AbstractEntity;
import com.sk.sample.siren.shared.base.AggregateRoot;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
public class Store extends AbstractEntity implements AggregateRoot {

	private String name;
	private String ownerAccountId;
	private String openYn;
	private String address;
	private StoreDescription storeDescription;


	public Store(String name, String ownerAccountId, String openYn, String address, StoreDescription storeDescription) {
		this.name = name;
		this.ownerAccountId = ownerAccountId;
		this.openYn = openYn;
		this.address = address;
		this.storeDescription = storeDescription;
		
	}
}