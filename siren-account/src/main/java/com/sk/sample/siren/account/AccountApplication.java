package com.sk.sample.siren.account;

import java.util.List;
import java.util.UUID;

import com.sk.sample.siren.account.domain.model.*;
import com.sk.sample.siren.account.domain.repository.AuthoritiesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.querydsl.core.types.Predicate;
import com.sk.sample.siren.account.domain.repository.AccountRepository;
import com.sk.sample.siren.shared.domain.Address;

@SpringBootApplication
public class AccountApplication {
	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}

	@Bean
	public CommandLineRunner execSampleCode(AccountRepository accountRepository, AuthoritiesRepository authoritiesRepository) {
		return (args) -> {
			insertAccounts(accountRepository, authoritiesRepository);
			displayAccounts(accountRepository);
			
			executeExample1(accountRepository);
		};
	}
		
	public void insertAccounts(AccountRepository accountRepository, AuthoritiesRepository authoritiesRepository) {
		
		Account account1 = new Account("hong@sk.com","1111", "홍길동", MemberType.BUYER);
		Authorities authorities = new Authorities();
		authorities.setId(UUID.randomUUID().toString());
		authorities.setUsername("hong@sk.com");
		authorities.setAuthority("ROLE_ADMIN");
		authoritiesRepository.save(authorities);
		accountRepository.save(account1);
		
		Account account2 = new Account("kang@sk.com","1111", "강호동", MemberType.BUYER, MembershipLevelType.VIP);
		account2.setAddress(new Address(12345, "서울시 강남구"));
		Authorities authoritie2 = new Authorities();
		authoritie2.setId(UUID.randomUUID().toString());
		authoritie2.setUsername("kang@sk.com");
		authoritie2.setAuthority("ROLE_ADMIN");
		authoritiesRepository.save(authoritie2);
		accountRepository.save(account2);
		
		Account account3 = new Account("yu@gmail.com","1111", "유재석", MemberType.SELLER);
		account3.setAddress(new Address(10000, "경기도 성남시"));
		Authorities authorities3 = new Authorities();
		authorities3.setId(UUID.randomUUID().toString());
		authorities3.setUsername("yu@gmail.com");
		authorities3.setAuthority("ROLE_ADMIN");
		authoritiesRepository.save(authorities3);
		accountRepository.save(account3);
		
		Account account4 = new Account("shin@sk.com","1111", "신동엽", MemberType.BUYER, MembershipLevelType.GOLD);
		account4.setAddress(new Address(12345, "서울시 강남구"));
		Authorities authorities4 = new Authorities();
		authorities4.setId(UUID.randomUUID().toString());
		authorities4.setUsername("shin@sk.com");
		authorities4.setAuthority("ROLE_ADMIN");
		authoritiesRepository.save(authorities4);
		accountRepository.save(account4);
	}
	
	public void displayAccounts(AccountRepository accountRepository) {
		System.out.println("***************************************************************");
		
		Iterable<Account> accountList = accountRepository.findAll();
		for(Account account : accountList) {
			System.out.println(account.toString());	
		}
		
		System.out.println("***************************************************************");
	}
	
	
	public void executeExample1(AccountRepository accountRepository) {
		Account account = accountRepository.findByEmail("hong@sk.com");
		
		account.setAddress(Address.builder().zipCode(10000).homeAddress("경기도 성남시").build());
		accountRepository.save(account);
		
		displayAccounts(accountRepository);
	}
	
	public void executeExample2(AccountRepository accountRepository) {
		List<Account> account = accountRepository.findByAddressZipCode(12345);
		System.out.println("Result: " + account.toString());
	}
	
	public void executeExample3(AccountRepository accountRepository) {
		List<Account> account = accountRepository.findByAddressHomeAddressLike("성남");
		System.out.println("Result: " + account.toString());
	}
	
	public void executeExample4(AccountRepository accountRepository) {
		QAccount.account.name.like("강%");
		Account account = accountRepository.findOne(QAccount.account.email.eq("hong@sk.com"));
		
		account.setAddress(Address.builder().zipCode(10000).homeAddress("경기도 성남시").build());
		accountRepository.save(account);
		
		displayAccounts(accountRepository);
	}
	
	public void executeExample5(AccountRepository accountRepository) {
		List<Account> account = accountRepository.findAll(QAccount.account.address.zipCode.eq(12345));
		System.out.println("Result: " + account.toString());
	}
	
	public void executeExample6(AccountRepository accountRepository) {
		List<Account> account = accountRepository.findAll(QAccount.account.address.homeAddress.like("성남"));
		System.out.println("Result: " + account.toString());
	}
	
	public void executeExample7(AccountRepository accountRepository) {
		Predicate predicate = QAccount.account.memberType.eq(MemberType.BUYER).and(
				              QAccount.account.membershipLevelType.eq(MembershipLevelType.VIP));
		List<Account> account = accountRepository.findAll(predicate);
		System.out.println("Result: " + account.toString());
	}
	
	/*
	@Bean
	public CommandLineRunner execSampleCode2(@Qualifier("accountLogic") AccountService accountService) {
		return (args) -> {
			Account account = new Account("iu@sk.com", "아이유", MemberType.BUYER, MembershipLevelType.VIP);
			accountService.register(account);
			
			Account result = accountService.findByEmail("iu@sk.com");
			System.out.println("Component API Result - " + result);
			
			result.setAddress(new Address(11111, "서울시 영등포구"));
			accountService.update(result.getId(), result);
			
			Account result2 = accountService.findByEmail("iu@sk.com");
			System.out.println("Component API Result2 - " + result2);
		};
	}
	*/
}
