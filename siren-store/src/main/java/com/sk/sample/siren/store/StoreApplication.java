package com.sk.sample.siren.store;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.config.EnableHypermediaSupport;

import com.sk.sample.siren.shared.domain.Address;
import com.sk.sample.siren.store.domain.model.Store;
import com.sk.sample.siren.store.domain.repository.StoreRepository;

@SpringBootApplication
@EnableHypermediaSupport(type=EnableHypermediaSupport.HypermediaType.HAL)
public class StoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner execSampleCode(StoreRepository storeRepository) {	
		return (args) -> {
			insertStores(storeRepository);
			displayStores(storeRepository);
		};
	}
	

	public void insertStores(StoreRepository storeRepository) {
		Store store1 = new Store("정자지점", "010-2544-5424");
		store1.setAddress(new Address(13254, "경기도 성남시 분당구 정자동 123-11"));
		storeRepository.save(store1);
		
		Store store2 = new Store("상점지점", "010-5412-2525");
		store2.setAddress(new Address(53152, "서울시 강남구 삼성동 379-13"));
		storeRepository.save(store2);		
		
		Store store3 = new Store("판교지점", "010-5487-5125");
		store3.setAddress(new Address(87921, "경기 성남시 분당구 삼평동 87"));
		storeRepository.save(store3);
		
		Store store4 = new Store("역삼지점", "010-8215-5564");
		store4.setAddress(new Address(12568, "서울시 강남구 역삼동 872-11"));
		storeRepository.save(store4);
		
		Store store5 = new Store("미금지점", "010-5454-8315");
		store5.setAddress(new Address(54544, "경기 성남시 분당구 미금동 585"));
		storeRepository.save(store5);		
	}

	
	public void displayStores(StoreRepository storeRepository) {
		System.out.println("displayStores start ******************************************");
		
		Iterable<Store> storeList = storeRepository.findAll();
		for(Store route : storeList) {
			System.out.println(route.toString());	
		}
		
		System.out.println("displayStores end ******************************************");
	}	
}
