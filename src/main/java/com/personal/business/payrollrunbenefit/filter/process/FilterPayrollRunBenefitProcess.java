package com.personal.business.payrollrunbenefit.filter.process;

import com.personal.business.payrollrunbenefit.entities.PayrollRunBenefit;
import com.personal.business.payrollrunbenefit.filter.inputs.FilterPayrollRunBenefitInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterPayrollRunBenefitProcess extends FunctionalProcess<FilterPayrollRunBenefitInput, PayrollRunBenefit> {

    public FilterPayrollRunBenefitProcess() {
        super("filter_payroll_run_benefit_");
    }

}
