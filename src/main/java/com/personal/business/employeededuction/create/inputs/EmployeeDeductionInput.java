package com.personal.business.employeededuction.create.inputs;

import com.personal.business.deduction.entities.Deduction;
import com.personal.business.employee.entities.Employee;
import com.personal.business.employeededuction.entities.EmployeeDeduction;
import com.personal.shared.inputs.BusinessInputBase;

public class EmployeeDeductionInput extends BusinessInputBase {

    private String deductionId;
    private String employeeId;

    public EmployeeDeductionInput() {
        super();
    }

    public void setDeductionId(String deductionId) {
        this.deductionId = deductionId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public EmployeeDeduction getEmployeeDeduction() {
        var employeeDeduction = this.id == null || this.id.isEmpty() ? new EmployeeDeduction() : new EmployeeDeduction(this.id);
        employeeDeduction.setDeduction(new Deduction(deductionId));
        employeeDeduction.setEmployee(new Employee(employeeId));
        employeeDeduction.setBusiness(this.getBusiness());
        employeeDeduction.setCreatedBy(sessionUser);
        return employeeDeduction;
    }
}
