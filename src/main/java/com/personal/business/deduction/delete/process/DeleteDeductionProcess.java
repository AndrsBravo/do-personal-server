package com.personal.business.deduction.delete.process;

import com.personal.business.deduction.entities.Deduction;
import com.personal.shared.process.SupplierProcess;

public class DeleteDeductionProcess extends SupplierProcess<Deduction> {

    public DeleteDeductionProcess() {
        super("delete_deduction_process");
    }

}
