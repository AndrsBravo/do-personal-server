package com.personal.management.payrolldeduction.filter.process;

import com.personal.management.payrolldeduction.entities.PayrollDeduction;
import com.personal.management.payrolldeduction.filter.inputs.FilterPayrollDeductionInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterPayrollDeductionProcess extends FunctionalProcess<FilterPayrollDeductionInput, PayrollDeduction> {

    public FilterPayrollDeductionProcess() {
        super("filter_payroll_deduction_process");
    }

}
