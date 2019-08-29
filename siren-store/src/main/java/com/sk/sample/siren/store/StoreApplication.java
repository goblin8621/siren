package com.sk.sample.siren.store;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.config.EnableHypermediaSupport;

import com.querydsl.core.types.Predicate;
import com.sk.sample.siren.shared.domain.Address;
import com.sk.sample.siren.store.domain.model.Store;
import com.sk.sample.siren.store.domain.model.StoreDescription;
import com.sk.sample.siren.store.domain.model.StoreType;
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
			deleteByStoreName(storeRepository);
			updateStoreNameByStoreName(storeRepository);
			updateStoreOpenYnByStoreName(storeRepository);
			updateStoreAddressYnByStoreName(storeRepository);
			updateStoreOwnerAccountIdYnByStoreName(storeRepository);
			updateStoreInfoYnByStoreName(storeRepository);
			updateStoreTypeYnByStoreName(storeRepository);

			displayStores(storeRepository);
		};
	}
	
	public void insertStores(StoreRepository storeRepository) {
		Store store1 = new Store("OnChoJeom", "yjkang11", "Y", "Seoul, GeumCheon-Gu", new StoreDescription(StoreType.FOOD, "Coffee and Dessert Store!"));
		storeRepository.save(store1);
		
		Store store2 = new Store("Seven Style", "yjkang11", "Y", "Icheon, Bubal-Eup", new StoreDescription(StoreType.CLOTHING, "Funky and Cute Clothing Store for Teens!"));
		storeRepository.save(store2);
		
		Store store3 = new Store("Happy Home Deco", "yjkang11", "N", "Daegu, Buk-Gu", new StoreDescription(StoreType.SHELTER, "Home Interior Props Shop"));
		storeRepository.save(store3);
		
		Store store4 = new Store("For the Inner Peace", "yjkang11", "Y", "Seongnam, BunDang-Gu", new StoreDescription(StoreType.ETC, "Yoga and Pilates Goods Shop"));
		storeRepository.save(store4);	
	}

	
	public void displayStores(StoreRepository storeRepository) {
		System.out.println("***************************************************************");
		
		Iterable<Store> storeList = storeRepository.findAll();
		for(Store store : storeList) {
			System.out.println(store.toString());	
		}
		
		System.out.println("***************************************************************");
	}
	
	public void deleteByStoreName(StoreRepository storeRepository) {
		Store store = storeRepository.findByName("OnChoJeom");
		storeRepository.delete(store);
	}
	
	public void updateStoreNameByStoreName(StoreRepository storeRepository) {
		Store store = storeRepository.findByName("For the Inner Peace");

		store.setName("ABC Yoga Shop");
		storeRepository.save(store);

	}
	
	public void updateStoreOpenYnByStoreName(StoreRepository storeRepository) {
		Store store = storeRepository.findByName("ABC Yoga Shop");

		store.setOpenYn("N");
		storeRepository.save(store);

	}
	
	public void updateStoreAddressYnByStoreName(StoreRepository storeRepository) {
		Store store = storeRepository.findByName("ABC Yoga Shop");

		store.setAddress("Daegu, Jung-Gu");
		storeRepository.save(store);

	}
	
	public void updateStoreOwnerAccountIdYnByStoreName(StoreRepository storeRepository) {
		Store store = storeRepository.findByName("ABC Yoga Shop");

		store.setOwnerAccountId("brightsoil");
		storeRepository.save(store);

	}
	
	public void updateStoreInfoYnByStoreName(StoreRepository storeRepository) {
		Store store = storeRepository.findByName("ABC Yoga Shop");

		store.setStoreDescription(new StoreDescription(store.getStoreDescription().getStoreType(), "Yoga Goods Shop"));
		storeRepository.save(store);

	}
	
	public void updateStoreTypeYnByStoreName(StoreRepository storeRepository) {
		Store store = storeRepository.findByName("ABC Yoga Shop");

		store.setStoreDescription(new StoreDescription(StoreType.ETC, store.getStoreDescription().getStoreInfo()));
		storeRepository.save(store);

	}
}
