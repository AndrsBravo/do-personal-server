package com.personal.business.employeebenefit.create.inputs;

import com.personal.business.benefit.entities.Benefit;
import com.personal.business.employee.entities.Employee;
import com.personal.business.employeebenefit.entities.EmployeeBenefit;
import com.personal.shared.inputs.BusinessInputBase;

public class EmployeeBenefitInput extends BusinessInputBase {

    private String benefitId;
    private String employeeId;

    public EmployeeBenefitInput() {
        super();
    }

    public void setBenefitId(String benefitId) {
        this.benefitId = benefitId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public EmployeeBenefit getEmployeeBenefit() {
        var employeeBenefit = this.id == null || this.id.isEmpty() ? new EmployeeBenefit() : new EmployeeBenefit(this.id);
        employeeBenefit.setBenefit(new Benefit(benefitId));
        employeeBenefit.setEmployee(new Employee(employeeId));
        employeeBenefit.setBusiness(this.getBusiness());
        employeeBenefit.setCreatedBy(sessionUser);
        return employeeBenefit;
    }
}
