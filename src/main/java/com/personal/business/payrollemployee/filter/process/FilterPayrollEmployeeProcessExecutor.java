package com.personal.business.payrollemployee.filter.process;

import com.personal.business.payrollemployee.entities.PayrollEmployee;
import com.personal.business.payrollemployee.filter.inputs.FilterPayrollEmployeeInput;
import com.personal.business.payrollemployee.filter.process.rules.FilterPayrollEmployeeRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterPayrollEmployeeProcessExecutor extends FunctionalProcessExecutor<FilterPayrollEmployeeProcess, FilterPayrollEmployeeInput, PayrollEmployee> {

    public FilterPayrollEmployeeProcessExecutor() {
        super(new FilterPayrollEmployeeProcess(), FilterPayrollEmployeeRule::new);
    }

    public static FilterPayrollEmployeeProcessExecutor builder() {
        return new FilterPayrollEmployeeProcessExecutor();
    }

}
