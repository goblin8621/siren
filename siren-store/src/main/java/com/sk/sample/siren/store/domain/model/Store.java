package com.sk.sample.siren.store.domain.model;

import javax.persistence.Entity;

import com.sk.sample.siren.shared.base.AbstractEntity;
import com.sk.sample.siren.shared.base.AggregateRoot;
import com.sk.sample.siren.shared.domain.Address;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
public class Store extends AbstractEntity implements AggregateRoot {
	
	private String name;
	private String phoneNo;
	private String openYN = "Y";
	
	private Address address;

	public Store(String name, String phoneNo) {
		this.name = name;
		this.phoneNo = phoneNo;
	}

}