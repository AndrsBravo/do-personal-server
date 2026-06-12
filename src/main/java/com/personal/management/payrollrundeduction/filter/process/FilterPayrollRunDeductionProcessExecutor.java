package com.personal.management.payrollrundeduction.filter.process;

import com.personal.management.payrollrundeduction.entities.PayrollRunDeduction;
import com.personal.management.payrollrundeduction.filter.inputs.FilterPayrollRunDeductionInput;
import com.personal.management.payrollrundeduction.filter.process.rules.FilterPayrollRunDeductionRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterPayrollRunDeductionProcessExecutor extends FunctionalProcessExecutor<FilterPayrollRunDeductionProcess, FilterPayrollRunDeductionInput, PayrollRunDeduction> {

    public FilterPayrollRunDeductionProcessExecutor() {
        super(new FilterPayrollRunDeductionProcess(), FilterPayrollRunDeductionRule::new);
    }

    public static FilterPayrollRunDeductionProcessExecutor builder() {
        return new FilterPayrollRunDeductionProcessExecutor();
    }

}
