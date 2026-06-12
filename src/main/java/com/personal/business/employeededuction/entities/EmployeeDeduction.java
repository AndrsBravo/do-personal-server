package com.personal.business.employeededuction.entities;

import com.personal.business.deduction.entities.Deduction;
import com.personal.business.employee.entities.Employee;
import com.personal.shared.entities.BusinessEntity;

public class EmployeeDeduction extends BusinessEntity {

    private Employee employee;
    private Deduction deduction;

    public EmployeeDeduction() {
        super();
    }

    public EmployeeDeduction(String id) {
        super(id);
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Deduction getDeduction() {
        return deduction;
    }

    public void setDeduction(Deduction deduction) {
        this.deduction = deduction;
    }

}
