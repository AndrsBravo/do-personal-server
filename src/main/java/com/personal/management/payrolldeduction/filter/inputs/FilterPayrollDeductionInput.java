package com.personal.management.payrolldeduction.filter.inputs;

import com.personal.management.shared.inputs.CountryFilterInputBase;

public class FilterPayrollDeductionInput extends CountryFilterInputBase {

    private String deductionId;
    private String payrollId;

    public FilterPayrollDeductionInput() {
        super();
    }

    public String getDeductionId() {
        return deductionId;
    }

    public void setDeductionId(String deductionId) {
        this.deductionId = deductionId;
    }

    public String getPayrollId() {
        return payrollId;
    }

    public void setPayrollId(String payrollId) {
        this.payrollId = payrollId;
    }

}
