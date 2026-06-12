package com.personal.management.payrollrunbenefit.filter.process;

import com.personal.management.payrollrunbenefit.entities.PayrollRunBenefit;
import com.personal.management.payrollrunbenefit.filter.inputs.FilterPayrollRunBenefitInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterPayrollRunBenefitProcess extends FunctionalProcess<FilterPayrollRunBenefitInput, PayrollRunBenefit> {

    public FilterPayrollRunBenefitProcess() {
        super("filter_payroll_run_benefit_");
    }

}
