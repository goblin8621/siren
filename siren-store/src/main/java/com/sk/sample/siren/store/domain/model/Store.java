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
	
	public Store(String name) {
		this.name = name;
	}
}

