package com.dh.demo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Created by Juan Zapata on 6/20/2017.
 */
@Document
public class SoldCarRegistry {
    @Id
    private String id;
    private Date sellingDate;
    @DBRef
    private Car car;
    @DBRef
    private Seller seller;
    @DBRef
    private Buyer buyer;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getSellingDate() {
        return sellingDate;
    }

    public void setSellingDate(Date sellingDate) {
        this.sellingDate = sellingDate;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }
}

