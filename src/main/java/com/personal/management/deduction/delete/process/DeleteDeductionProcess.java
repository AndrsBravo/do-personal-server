package com.personal.management.deduction.delete.process;

import com.personal.management.deduction.entities.Deduction;
import com.personal.shared.process.SupplierProcess;

public class DeleteDeductionProcess extends SupplierProcess<Deduction> {

    public DeleteDeductionProcess() {
        super("delete_deduction_process");
    }

}
