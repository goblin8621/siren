package com.sk.sample.siren.account.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.querydsl.core.types.Predicate;
import com.sk.sample.siren.account.domain.model.Account;

@RepositoryRestResource
public interface AccountRepository extends PagingAndSortingRepository<Account, Long>,
                                           QueryDslPredicateExecutor<Account> {
	
	Account findByEmail(@Param("email") String email);
	List<Account> findByNameLike(@Param("name") String name);
	List<Account> findAll();
	
	List<Account> findByAddressZipCode(@Param("zipCode") Integer zipCode);
	
	@Query("select a from Account a where a.address.homeAddress like %?1%")
	List<Account> findByAddressHomeAddressLike(@Param("homeAddress") String homeAddress);
	

	List<Account> findAll(Predicate predicate);
	Account findByAccountId(@Param("accounId") String accounId);
	
	//@Query("delete from Account a where a.accountId = ?1")
	Account deleteByAccountId(@Param("accountId") String accountId);
	
}
