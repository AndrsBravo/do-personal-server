package com.personal.business.payrollrunresult.filter.process;

import com.personal.business.payrollrunresult.entities.PayrollRunResult;
import com.personal.business.payrollrunresult.filter.inputs.FilterPayrollRunResultInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterPayrollRunResultProcess extends FunctionalProcess<FilterPayrollRunResultInput, PayrollRunResult> {

    public FilterPayrollRunResultProcess() {
        super("filter_payroll_run_result_process");
    }

}
