package com.sk.sample.siren.account.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authorities")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Authorities {
    
    @Id
    private String id;
    @Column(nullable = false)
    private String accountId;
    @Column(nullable = false)
    private String authority;
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getAuthority() {
        return authority;
    }
    
    public void setAuthority(String authority) {
        this.authority = authority;
    }
    
    public String getAccountId() {
        return accountId;
    }
    
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    
    @Override
    public String toString() {
        return "Authorities{" + "id='" + id + '\'' + ", accountId='" + accountId + '\'' + ", authority='" + authority + '\'' + '}';
    }
}
