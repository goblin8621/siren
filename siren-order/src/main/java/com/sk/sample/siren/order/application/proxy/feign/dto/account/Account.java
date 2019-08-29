package com.sk.sample.siren.order.application.proxy.feign.dto.account;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.sk.sample.siren.shared.domain.Address;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Account {

	private String accountId;
	private String pw;
	private String email;
	private String name;
	private String phoneNumber;
	
	
	@Enumerated(EnumType.ORDINAL)
	private MemberType memberType;
	
	@Enumerated(EnumType.STRING)
	private MembershipLevelType membershipLevelType;
	
	private Address address;
	
	
	public Account(String accountId, String pw, String email, String name, MemberType memberType, MembershipLevelType membershipLevelType, String phoneNumber) {
		this.accountId=accountId;
		this.pw=pw;
		this.email = email;
		this.name = name;
		this.memberType = memberType;
		this.membershipLevelType = membershipLevelType;
		this.phoneNumber = phoneNumber;

	}
	
	public Account(String accountId, String pw, String email, String name, MemberType memberType,  String phoneNumber) {
		this.accountId=accountId;
		this.pw=pw;
		this.email = email;
		this.name = name;
		this.memberType = memberType;
		this.phoneNumber = phoneNumber;

	}
	
}

