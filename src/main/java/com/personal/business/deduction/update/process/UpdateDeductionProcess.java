package com.personal.business.deduction.update.process;

import com.personal.business.deduction.entities.Deduction;
import com.personal.shared.process.SupplierProcess;

public class UpdateDeductionProcess extends SupplierProcess<Deduction> {

    public UpdateDeductionProcess() {
        super("update_deduction_process");
    }

}
