package com.personal.business.payrollrunbenefit.filter.process;

import com.personal.business.payrollrunbenefit.entities.PayrollRunBenefit;
import com.personal.business.payrollrunbenefit.filter.inputs.FilterPayrollRunBenefitInput;
import com.personal.business.payrollrunbenefit.filter.process.rules.FilterPayrollRunBenefitRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterPayrollRunBenefitProcessExecutor extends FunctionalProcessExecutor<FilterPayrollRunBenefitProcess, FilterPayrollRunBenefitInput, PayrollRunBenefit> {

    public FilterPayrollRunBenefitProcessExecutor() {
        super(new FilterPayrollRunBenefitProcess(), FilterPayrollRunBenefitRule::new);
    }

    public static FilterPayrollRunBenefitProcessExecutor builder() {
        return new FilterPayrollRunBenefitProcessExecutor();
    }

}
