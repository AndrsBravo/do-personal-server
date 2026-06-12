package com.personal.backoffice.system.entities;

import com.personal.shared.entities.BaseEntity;

public class DataBase extends BaseEntity {

    private String name;

    public DataBase() {
    }

    public DataBase(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
