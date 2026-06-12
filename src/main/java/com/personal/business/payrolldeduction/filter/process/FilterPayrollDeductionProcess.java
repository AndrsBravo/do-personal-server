package com.personal.business.payrolldeduction.filter.process;

import com.personal.business.payrolldeduction.entities.PayrollDeduction;
import com.personal.business.payrolldeduction.filter.inputs.FilterPayrollDeductionInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterPayrollDeductionProcess extends FunctionalProcess<FilterPayrollDeductionInput, PayrollDeduction> {

    public FilterPayrollDeductionProcess() {
        super("filter_payroll_deduction_process");
    }

}
