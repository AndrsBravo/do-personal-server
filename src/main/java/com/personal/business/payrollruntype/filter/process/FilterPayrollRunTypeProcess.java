package com.personal.business.payrollruntype.filter.process;

import com.personal.business.shared.entities.TypeEntity;
import com.personal.business.shared.inputs.BusinessFilterTypeInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterPayrollRunTypeProcess extends FunctionalProcess<BusinessFilterTypeInput, TypeEntity> {

    public FilterPayrollRunTypeProcess() {
        super("filter_payroll_run_type_process");
    }

}
