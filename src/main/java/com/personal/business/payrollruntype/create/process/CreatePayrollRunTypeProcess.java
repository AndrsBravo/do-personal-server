package com.personal.business.payrollruntype.create.process;

import com.personal.business.shared.entities.TypeEntity;
import com.personal.shared.process.SupplierProcess;

public class CreatePayrollRunTypeProcess extends SupplierProcess<TypeEntity> {

    public CreatePayrollRunTypeProcess() {
        super("create_payroll_run_type_process");
    }

}
