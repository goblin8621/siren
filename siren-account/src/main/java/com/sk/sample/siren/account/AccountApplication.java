package com.sk.sample.siren.account;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.querydsl.core.types.Predicate;
import com.sk.sample.siren.account.domain.model.Account;
import com.sk.sample.siren.account.domain.model.MemberType;
import com.sk.sample.siren.account.domain.model.MembershipLevelType;
import com.sk.sample.siren.account.domain.model.QAccount;
import com.sk.sample.siren.account.domain.repository.AccountRepository;
import com.sk.sample.siren.shared.domain.Address;

@SpringBootApplication
public class AccountApplication {
	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}

	@Bean
	public CommandLineRunner execSampleCode(AccountRepository accountRepository) {	
		return (args) -> {
			insertAccounts(accountRepository);
			displayAccounts(accountRepository);
			
			executeExample00(accountRepository);		//select
			//executeExample01(accountRepository);		//delete
			executeExample02(accountRepository);		//update
		};
	}
		
	public void insertAccounts(AccountRepository accountRepository) {
		
		Account account1 = new Account("skyk", "1234", "skyk@sk.com", "안영기", MemberType.BUYER, MembershipLevelType.VIP ,  "010-1111-2222");
		account1.setAddress(new Address(00000, "성남시 분당구"));
		accountRepository.save(account1);
		
		Account account2 = new Account("brightsoil","1234", "brightsoil@sk.com", "김현규", MemberType.SELLER, "010-2222-2222");
		account2.setAddress(new Address(12345, "서울시 송파구"));
		accountRepository.save(account2);
		
		Account account3 = new Account("edgar.kim","1234","edgar.kim@sk.com", "김종국", MemberType.SELLER,  "010-3333-2222");
		account3.setAddress(new Address(11111, "서울시 강동구"));
		accountRepository.save(account3);
		
		Account account4 = new Account("goblin8621","1234","goblin8621@sk.com", "백동훈", MemberType.BUYER, MembershipLevelType.GOLD, "010-4444-2222");
		account4.setAddress(new Address(22222, "서울시 노원구"));
		accountRepository.save(account4);
		
		Account account5 = new Account("kangyj11","1234","kangyj11@sk.com", "강영주", MemberType.BUYER, MembershipLevelType.GOLD, "010-5555-2222");
		account5.setAddress(new Address(33333, "경기도 이천시"));
		accountRepository.save(account5);
	}
	
	public void displayAccounts(AccountRepository accountRepository) {
		System.out.println("***************************************************************");
		
		Iterable<Account> accountList = accountRepository.findAll();
		for(Account account : accountList) {
			System.out.println(account.toString());	
		}
		
		System.out.println("***************************************************************");
	}
	
	
	
	public void executeExample00(AccountRepository accountRepository) {
		Account account = accountRepository.findByAccountId("brightsoil");
		System.out.println(account.toString());	

	}
	
	public void executeExample01(AccountRepository accountRepository) {
		Account account = accountRepository.findByAccountId("brightsoil");
		accountRepository.delete(account);
		displayAccounts(accountRepository);

	}

	public void executeExample02(AccountRepository accountRepository) {
		Account account = accountRepository.findByAccountId("brightsoil");
		
		account.setAddress(Address.builder().zipCode(10000).homeAddress("제주도 서귀포시").build());
		account.setEmail("XXXXXXXXXXXXX.sk.com");
		accountRepository.save(account);
		
		displayAccounts(accountRepository);
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
