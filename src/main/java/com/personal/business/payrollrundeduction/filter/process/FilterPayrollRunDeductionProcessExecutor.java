package com.personal.business.payrollrundeduction.filter.process;

import com.personal.business.payrollrundeduction.entities.PayrollRunDeduction;
import com.personal.business.payrollrundeduction.filter.inputs.FilterPayrollRunDeductionInput;
import com.personal.business.payrollrundeduction.filter.process.rules.FilterPayrollRunDeductionRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterPayrollRunDeductionProcessExecutor extends FunctionalProcessExecutor<FilterPayrollRunDeductionProcess, FilterPayrollRunDeductionInput, PayrollRunDeduction> {

    public FilterPayrollRunDeductionProcessExecutor() {
        super(new FilterPayrollRunDeductionProcess(), FilterPayrollRunDeductionRule::new);
    }

    public static FilterPayrollRunDeductionProcessExecutor builder() {
        return new FilterPayrollRunDeductionProcessExecutor();
    }

}
