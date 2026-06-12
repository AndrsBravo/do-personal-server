package com.personal.business.payrollrundeduction.filter.inputs;

import com.personal.business.shared.inputs.BusinessFilterInputBase;

public class FilterPayrollRunDeductionInput extends BusinessFilterInputBase {

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
