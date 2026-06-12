package com.personal.management.payroll.filter.process;

import com.personal.management.payroll.entities.Payroll;
import com.personal.management.payroll.filter.inputs.FilterPayrollInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterPayrollProcess extends FunctionalProcess<FilterPayrollInput, Payroll> {

    public FilterPayrollProcess() {
        super("filter_payroll_");
    }

}
