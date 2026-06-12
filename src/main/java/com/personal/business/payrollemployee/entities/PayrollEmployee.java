package com.personal.business.payrollemployee.entities;

import com.personal.business.employee.entities.Employee;
import com.personal.business.payroll.entities.Payroll;
import com.personal.shared.entities.BusinessEntity;

public class PayrollEmployee extends BusinessEntity {

    private Payroll payroll;
    private Employee employee;

    public PayrollEmployee() {
        super();
    }

    public PayrollEmployee(String id) {
        super(id);
    }

    public Payroll getPayroll() {
        return payroll;
    }

    public void setPayroll(Payroll payroll) {
        this.payroll = payroll;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}
