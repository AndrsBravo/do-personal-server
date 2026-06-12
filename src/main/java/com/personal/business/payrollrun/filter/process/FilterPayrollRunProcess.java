package com.personal.business.payrollrun.filter.process;

import com.personal.business.payrollrun.entities.PayrollRun;
import com.personal.business.payrollrun.filter.inputs.FilterPayrollRunInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterPayrollRunProcess extends FunctionalProcess<FilterPayrollRunInput, PayrollRun> {

    public FilterPayrollRunProcess() {
        super("filter_payroll_run_process");
    }

}
