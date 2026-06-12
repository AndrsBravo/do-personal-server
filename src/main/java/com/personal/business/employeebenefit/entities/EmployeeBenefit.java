package com.personal.business.employeebenefit.entities;

import com.personal.business.benefit.entities.Benefit;
import com.personal.business.employee.entities.Employee;
import com.personal.shared.entities.BusinessEntity;

public class EmployeeBenefit extends BusinessEntity {

    private Employee employee;
    private Benefit benefit;

    public EmployeeBenefit() {
        super();
    }

    public EmployeeBenefit(String id) {
        super(id);
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Benefit getBenefit() {
        return benefit;
    }

    public void setBenefit(Benefit benefit) {
        this.benefit = benefit;
    }

}
