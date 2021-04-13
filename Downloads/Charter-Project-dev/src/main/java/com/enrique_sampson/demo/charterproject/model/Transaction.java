package com.enrique_sampson.demo.charterproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import javax.persistence.*;


@Entity
@Getter
public class Transaction {

    @Id
    @GeneratedValue
    private Integer id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn
    private User user;

    private Double total;

    @Transient
    @JsonInclude
    private Long points;


    public Transaction(){
        super();
    }

    public Transaction(Integer id, User user, Double total){
        super();
        this.id = id;
        this.user = user;
        this.total = total;

    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public void setPoints(Long points) {
        this.points = points;
    }

    public Long getPoints(){
        this.points = 0l;

        if (this.total > 50 && this.total <= 100){
            this.points+= (this.total.intValue() - 50);
        }else if(this.total >100){
            this.points+=((this.total.intValue() - 100)*2)+50;
        }

        return this.points;
    }



}
