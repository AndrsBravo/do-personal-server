package com.personal.business.payrollemployee.filter.process;

import com.personal.business.payrollemployee.entities.PayrollEmployee;
import com.personal.business.payrollemployee.filter.inputs.FilterPayrollEmployeeInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterPayrollEmployeeProcess extends FunctionalProcess<FilterPayrollEmployeeInput, PayrollEmployee> {

    public FilterPayrollEmployeeProcess() {
        super("filter_payroll_employee_process");
    }

}
