package com.personal.business.country.entities;

import com.personal.shared.entities.ShortEntity;

public class Country extends ShortEntity {

    private String name;
    private String code;

    public Country() {
        super();
    }

    public Country(String id) {
        super(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
