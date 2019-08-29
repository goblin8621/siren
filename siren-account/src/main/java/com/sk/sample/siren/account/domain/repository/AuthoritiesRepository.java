package com.sk.sample.siren.account.domain.repository;

import com.sk.sample.siren.account.domain.model.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthoritiesRepository extends JpaRepository<Authorities, String> {
}
