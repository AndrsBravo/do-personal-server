package com.personal.business.employee.create.inputs;

import com.personal.backoffice.business.api.inputs.BusinessInput;
import com.personal.business.employee.entities.Employee;

public class EmployeeInput extends BusinessInput {

    private String name;
    private String lastName;

    public EmployeeInput() {
        super();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Employee getEmployee() {
        var employee = this.id == null || this.id.isEmpty() ? new Employee() : new Employee(this.id);
        employee.setName(name);
        employee.setLastName(lastName);
        employee.setBusiness(this.getBusiness());
        return employee;
    }
}
