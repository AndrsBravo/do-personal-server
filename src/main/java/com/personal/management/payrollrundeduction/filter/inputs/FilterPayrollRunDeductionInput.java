package com.personal.management.payrollrundeduction.filter.inputs;

import com.personal.management.shared.inputs.CountryFilterInputBase;

public class FilterPayrollRunDeductionInput extends CountryFilterInputBase {

    private String deductionId;
    private String payrollRunId;

    public FilterPayrollRunDeductionInput() {
        super();
    }

    public String getDeductionId() {
        return deductionId;
    }

    public void setDeductionId(String deductionId) {
        this.deductionId = deductionId;
    }

    public String getPayrollRunId() {
        return payrollRunId;
    }

    public void setPayrollRunId(String payrollRunId) {
        this.payrollRunId = payrollRunId;
    }

}
