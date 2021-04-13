package com.enrique_sampson.demo.charterproject.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity
@Getter
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    private String name;

    @JsonInclude
    @Transient
    private Long rewardPoints;

    @OneToMany(mappedBy = "user", cascade = CascadeType.MERGE, orphanRemoval=true)
    private Set<Transaction> transactions;

    @JsonInclude
    @Transient
    private Double totalPurchases;

    public User(){
        super();
    }

    public User(Integer id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRewardPoints() {
        if (transactions == null || transactions.isEmpty()) return 0L;

        return transactions.stream().map(x -> x.getPoints().intValue()).reduce(0, Integer::sum).longValue();
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Double getTotalPurchases() {
        if (transactions == null || transactions.isEmpty()) return 0d;

        return transactions.stream().map(Transaction::getTotal).reduce(0d, Double::sum);
    }


}
