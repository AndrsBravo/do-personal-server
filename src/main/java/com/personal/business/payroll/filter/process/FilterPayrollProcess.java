package com.personal.business.payroll.filter.process;

import com.personal.business.payroll.entities.Payroll;
import com.personal.business.payroll.filter.inputs.FilterPayrollInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterPayrollProcess extends FunctionalProcess<FilterPayrollInput, Payroll> {

    public FilterPayrollProcess() {
        super("filter_payroll_");
    }

}
