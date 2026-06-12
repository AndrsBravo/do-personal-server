package com.personal.business.payrollemployee.filter.inputs;

import com.personal.business.shared.inputs.BusinessFilterInputBase;

public class FilterPayrollEmployeeInput extends BusinessFilterInputBase {

    private String employeeId;
    private String payrollId;

    public FilterPayrollEmployeeInput() {
        super();
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getPayrollId() {
        return payrollId;
    }

    public void setPayrollId(String payrollId) {
        this.payrollId = payrollId;
    }

}
