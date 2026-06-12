package com.personal.business.employee.filter.inputs;

import com.personal.business.shared.inputs.BusinessFilterInputBase;

public class FilterEmployeeInput extends BusinessFilterInputBase {

    private String name;
    private String lastName;

    public FilterEmployeeInput() {
        super();
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
