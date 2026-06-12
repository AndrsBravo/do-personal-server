package com.personal.business.benefit.delete.process;

import com.personal.business.benefit.entities.Benefit;
import com.personal.shared.process.SupplierProcess;

public class DeleteBenefitProcess extends SupplierProcess<Benefit> {

    public DeleteBenefitProcess() {
        super("delete_benefit_process");
    }

}
