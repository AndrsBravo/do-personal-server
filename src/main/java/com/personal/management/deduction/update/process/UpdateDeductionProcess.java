package com.personal.management.deduction.update.process;

import com.personal.management.deduction.entities.Deduction;
import com.personal.shared.process.SupplierProcess;

public class UpdateDeductionProcess extends SupplierProcess<Deduction> {

    public UpdateDeductionProcess() {
        super("update_deduction_process");
    }

}
