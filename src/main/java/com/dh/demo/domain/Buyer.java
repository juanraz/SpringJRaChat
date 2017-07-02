package com.dh.demo.domain;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Juan Zapata on 6/18/2017.
 */
@Document
public class Buyer extends Person {
    private String profession;
    private String cel;

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }
}
