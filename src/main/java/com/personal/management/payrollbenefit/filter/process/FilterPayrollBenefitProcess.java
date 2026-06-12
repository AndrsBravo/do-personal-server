package com.personal.management.payrollbenefit.filter.process;

import com.personal.management.payrollbenefit.entities.PayrollBenefit;
import com.personal.management.payrollbenefit.filter.inputs.FilterPayrollBenefitInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterPayrollBenefitProcess extends FunctionalProcess<FilterPayrollBenefitInput, PayrollBenefit> {

    public FilterPayrollBenefitProcess() {
        super("filter_payroll_benefit_");
    }

}
