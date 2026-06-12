package com.personal.backoffice.business.entities;

import com.personal.backoffice.country.entities.Country;
import com.personal.shared.entities.ClientEntity;

public class Business extends ClientEntity {

    private String name;
    private String dbName;
    private Country country;

    public Business() {
        super();
    }

    public Business(String id) {
        super(id);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Country getCountry() {
        return country;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getDbName() {
        return dbName;
    }
}
