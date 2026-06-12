package com.personal.management.payrollruntype.update.process;

import com.personal.management.shared.entities.TypeEntity;
import com.personal.shared.process.SupplierProcess;

public class UpdatePayrollRunTypeProcess extends SupplierProcess<TypeEntity> {

    public UpdatePayrollRunTypeProcess() {
        super("update_payroll_run_type_process");
    }

}
