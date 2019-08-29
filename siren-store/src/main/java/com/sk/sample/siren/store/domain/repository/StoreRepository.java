package com.sk.sample.siren.store.domain.repository;

import java.util.List;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.querydsl.core.types.Predicate;
import com.sk.sample.siren.store.domain.model.Store;
import com.sk.sample.siren.store.domain.model.StoreType;

@RepositoryRestResource
public interface StoreRepository extends PagingAndSortingRepository<Store, Long>,
                                           QueryDslPredicateExecutor<Store> {
	List<Store> findAll(Predicate predicate); 

	Store findByName(@Param("name") String name);

	List<Store> findByStoreDescriptionStoreType(@Param("storeType") StoreType storeType);

	
}
