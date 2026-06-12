package com.personal.business.payrollrundeduction.filter.process;

import com.personal.business.payrollrundeduction.entities.PayrollRunDeduction;
import com.personal.business.payrollrundeduction.filter.inputs.FilterPayrollRunDeductionInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterPayrollRunDeductionProcess extends FunctionalProcess<FilterPayrollRunDeductionInput, PayrollRunDeduction> {

    public FilterPayrollRunDeductionProcess() {
        super("filter_payroll_run_deduction_process");
    }

}
