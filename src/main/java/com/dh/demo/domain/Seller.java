package com.dh.demo.domain;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Juan Zapata on 6/18/2017.
 */
@Document
public class Seller extends Person {
    private int num_cars_sold;

    public int getNum_cars_sold() {
        return num_cars_sold;
    }

    public void setNum_cars_sold(int num_cars_sold) {
        this.num_cars_sold = num_cars_sold;
    }
}
