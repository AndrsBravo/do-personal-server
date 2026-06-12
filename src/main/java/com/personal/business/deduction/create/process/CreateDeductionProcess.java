package com.personal.business.deduction.create.process;

import com.personal.business.deduction.entities.Deduction;
import com.personal.shared.process.SupplierProcess;

public class CreateDeductionProcess extends SupplierProcess<Deduction> {

    public CreateDeductionProcess() {
        super("create_deduction_process");
    }

}
