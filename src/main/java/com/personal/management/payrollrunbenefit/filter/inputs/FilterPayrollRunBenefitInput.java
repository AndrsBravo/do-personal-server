package com.personal.management.payrollrunbenefit.filter.inputs;

import com.personal.backoffice.shared.inputs.CountryFilterInputBase;

public class FilterPayrollRunBenefitInput extends CountryFilterInputBase {

    private String benefitId;
    private String payrollRunId;

    public FilterPayrollRunBenefitInput() {
        super();
    }

    public String getBenefitId() {
        return benefitId;
    }

    public void setBenefitId(String benefitId) {
        this.benefitId = benefitId;
    }

    public String getPayrollRunId() {
        return payrollRunId;
    }

    public void setPayrollRunId(String payrollRunId) {
        this.payrollRunId = payrollRunId;
    }

}
