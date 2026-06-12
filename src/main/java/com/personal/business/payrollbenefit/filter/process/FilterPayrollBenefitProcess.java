package com.personal.business.payrollbenefit.filter.process;

import com.personal.business.payrollbenefit.entities.PayrollBenefit;
import com.personal.business.payrollbenefit.filter.inputs.FilterPayrollBenefitInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterPayrollBenefitProcess extends FunctionalProcess<FilterPayrollBenefitInput, PayrollBenefit> {

    public FilterPayrollBenefitProcess() {
        super("filter_payroll_benefit_");
    }

}
