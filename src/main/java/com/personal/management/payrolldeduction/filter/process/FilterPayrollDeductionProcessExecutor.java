package com.personal.management.payrolldeduction.filter.process;

import com.personal.management.payrolldeduction.entities.PayrollDeduction;
import com.personal.management.payrolldeduction.filter.inputs.FilterPayrollDeductionInput;
import com.personal.management.payrolldeduction.filter.process.rules.FilterPayrollDeductionRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterPayrollDeductionProcessExecutor extends FunctionalProcessExecutor<FilterPayrollDeductionProcess, FilterPayrollDeductionInput, PayrollDeduction> {

    public FilterPayrollDeductionProcessExecutor() {
        super(new FilterPayrollDeductionProcess(), FilterPayrollDeductionRule::new);
    }

    public static FilterPayrollDeductionProcessExecutor builder() {
        return new FilterPayrollDeductionProcessExecutor();
    }

}
