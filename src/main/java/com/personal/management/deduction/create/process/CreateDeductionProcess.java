package com.personal.management.deduction.create.process;

import com.personal.management.deduction.entities.Deduction;
import com.personal.shared.process.SupplierProcess;

public class CreateDeductionProcess extends SupplierProcess<Deduction> {

    public CreateDeductionProcess() {
        super("create_deduction_process");
    }

}
