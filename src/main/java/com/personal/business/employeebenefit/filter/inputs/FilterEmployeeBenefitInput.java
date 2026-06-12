package com.personal.business.employeebenefit.filter.inputs;

import com.personal.business.shared.inputs.BusinessFilterInputBase;

public class FilterEmployeeBenefitInput extends BusinessFilterInputBase {

    private String benefitId;
    private String employeeId;

    public FilterEmployeeBenefitInput() {
        super();
    }

    public String getBenefitId() {
        return benefitId;
    }

    public void setBenefitId(String benefitId) {
        this.benefitId = benefitId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

}
