package com.personal.management.payrollbenefit.filter.inputs;

import com.personal.management.shared.inputs.CountryFilterInputBase;

public class FilterPayrollBenefitInput extends CountryFilterInputBase {

    private String benefitId;
    private String payrollId;

    public FilterPayrollBenefitInput() {
        super();
    }

    public String getBenefitId() {
        return benefitId;
    }

    public void setBenefitId(String benefitId) {
        this.benefitId = benefitId;
    }

    public String getPayrollId() {
        return payrollId;
    }

    public void setPayrollId(String payrollId) {
        this.payrollId = payrollId;
    }

}
