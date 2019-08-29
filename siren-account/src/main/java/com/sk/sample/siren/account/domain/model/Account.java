package com.sk.sample.siren.account.domain.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.sk.sample.siren.shared.base.AbstractEntity;
import com.sk.sample.siren.shared.base.AggregateRoot;
import com.sk.sample.siren.shared.domain.Address;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
public class Account extends AbstractEntity implements AggregateRoot {
	private String email;
	private String name;
	private String password;
	
	@Enumerated(EnumType.ORDINAL)
	private MemberType memberType;
	
	@Enumerated(EnumType.STRING)
	private MembershipLevelType membershipLevelType;
	
	private Address address;
	
	public Account(String email, String password, String name, MemberType memberType) {
		this(email, password, name, memberType, MembershipLevelType.SILVER);
	}
	
	public Account(String email, String password, String name, MemberType memberType, MembershipLevelType membershipLevelType) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.memberType = memberType;
		this.membershipLevelType = membershipLevelType;

	}
}

