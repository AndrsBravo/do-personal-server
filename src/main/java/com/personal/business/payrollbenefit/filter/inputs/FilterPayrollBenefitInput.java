package com.personal.business.payrollbenefit.filter.inputs;

import com.personal.business.shared.inputs.BusinessFilterInputBase;

public class FilterPayrollBenefitInput extends BusinessFilterInputBase {

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
