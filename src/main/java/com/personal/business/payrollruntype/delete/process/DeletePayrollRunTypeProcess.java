package com.personal.business.payrollruntype.delete.process;

import com.personal.business.shared.entities.TypeEntity;
import com.personal.shared.process.SupplierProcess;

public class DeletePayrollRunTypeProcess extends SupplierProcess<TypeEntity> {

    public DeletePayrollRunTypeProcess() {
        super("delete_payroll_run_type_process");
    }

}
