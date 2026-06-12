package com.personal.business.employee.entities;

import com.personal.shared.entities.BusinessEntity;

public class Employee extends BusinessEntity {

    private String name;
    private String lastName;

    public Employee() {
        super();
    }

    public Employee(String id) {
        super(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
