package com.personal.business.payrollrunbenefit.filter.inputs;

import com.personal.business.shared.inputs.BusinessFilterInputBase;

public class FilterPayrollRunBenefitInput extends BusinessFilterInputBase {

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
