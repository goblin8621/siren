package com.sk.sample.siren.product.domain.repository;

import java.util.List;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.querydsl.core.types.Predicate;
import com.sk.sample.siren.product.domain.model.Product;

@RepositoryRestResource
public interface ProductRepository
		extends PagingAndSortingRepository<Product, Long>, QueryDslPredicateExecutor<Product> {
	List<Product> findAll(Predicate predicate);
}
