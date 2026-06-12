package com.personal.business.business.entities;

import com.personal.shared.entities.BusinessEntity;

public class Business extends BusinessEntity {

    private String name;
    private String dbName;

    public Business() {
        super();
    }

    public Business(String id) {
        super(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDataBaseName() {
        return dbName;
    }

    public void setDataBaseName(String dbName) {
        this.dbName = dbName;
    }

}
