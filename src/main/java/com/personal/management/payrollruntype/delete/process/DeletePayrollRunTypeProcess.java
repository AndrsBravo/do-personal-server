package com.personal.management.payrollruntype.delete.process;

import com.personal.management.shared.entities.TypeEntity;
import com.personal.shared.process.SupplierProcess;

public class DeletePayrollRunTypeProcess extends SupplierProcess<TypeEntity> {

    public DeletePayrollRunTypeProcess() {
        super("delete_payroll_run_type_process");
    }

}
