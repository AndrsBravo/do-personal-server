package com.personal.business.employeededuction.filter.inputs;

import com.personal.business.shared.inputs.BusinessFilterInputBase;

public class FilterEmployeeDeductionInput extends BusinessFilterInputBase {

    private String deductionId;
    private String employeeId;

    public FilterEmployeeDeductionInput() {
        super();
    }

    public String getDeductionId() {
        return deductionId;
    }

    public void setDeductionId(String deductionId) {
        this.deductionId = deductionId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

}
