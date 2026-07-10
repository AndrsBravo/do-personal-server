package com.personal.management.payrollruntype.filter.process;

import com.personal.backoffice.shared.entities.TypeEntity;
import com.personal.shared.inputs.FilterTypeInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterPayrollRunTypeProcess extends FunctionalProcess<FilterTypeInput, TypeEntity> {

    public FilterPayrollRunTypeProcess() {
        super("filter_payroll_run_type_process");
    }

}
