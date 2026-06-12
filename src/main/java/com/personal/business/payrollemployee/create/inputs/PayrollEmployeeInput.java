package com.personal.business.payrollemployee.create.inputs;

import com.personal.business.employee.entities.Employee;
import com.personal.business.payroll.entities.Payroll;
import com.personal.business.payrollemployee.entities.PayrollEmployee;
import com.personal.shared.inputs.BusinessInputBase;

public class PayrollEmployeeInput extends BusinessInputBase {

    private String employeeId;
    private String payrollId;

    public PayrollEmployeeInput() {
        super();
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setPayrollId(String payrollId) {
        this.payrollId = payrollId;
    }

    public PayrollEmployee getPayrollEmployee() {
        var payrollEmployee = this.id == null || this.id.isEmpty() ? new PayrollEmployee() : new PayrollEmployee(this.id);
        payrollEmployee.setEmployee(new Employee(employeeId));
        payrollEmployee.setPayroll(new Payroll(payrollId));
        payrollEmployee.setBusiness(this.getBusiness());
        payrollEmployee.setCreatedBy(sessionUser);
        return payrollEmployee;
    }
}
