package com.personal.business.payrollbenefit.filter.process;

import com.personal.business.payrollbenefit.entities.PayrollBenefit;
import com.personal.business.payrollbenefit.filter.inputs.FilterPayrollBenefitInput;
import com.personal.business.payrollbenefit.filter.process.rules.FilterPayrollBenefitRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterPayrollBenefitProcessExecutor extends FunctionalProcessExecutor<FilterPayrollBenefitProcess, FilterPayrollBenefitInput, PayrollBenefit> {

    public FilterPayrollBenefitProcessExecutor() {
        super(new FilterPayrollBenefitProcess(), FilterPayrollBenefitRule::new);
    }

    public static FilterPayrollBenefitProcessExecutor builder() {
        return new FilterPayrollBenefitProcessExecutor();
    }

}
