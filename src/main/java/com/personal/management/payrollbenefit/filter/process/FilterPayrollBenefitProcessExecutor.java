package com.personal.management.payrollbenefit.filter.process;

import com.personal.management.payrollbenefit.entities.PayrollBenefit;
import com.personal.management.payrollbenefit.filter.inputs.FilterPayrollBenefitInput;
import com.personal.management.payrollbenefit.filter.process.rules.FilterPayrollBenefitRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterPayrollBenefitProcessExecutor extends FunctionalProcessExecutor<FilterPayrollBenefitProcess, FilterPayrollBenefitInput, PayrollBenefit> {

    public FilterPayrollBenefitProcessExecutor() {
        super(new FilterPayrollBenefitProcess(), FilterPayrollBenefitRule::new);
    }

    public static FilterPayrollBenefitProcessExecutor builder() {
        return new FilterPayrollBenefitProcessExecutor();
    }

}
