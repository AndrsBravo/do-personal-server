package com.personal.management.deductionrate.delete.process;

import com.personal.management.deductionrate.entities.DeductionRate;
import com.personal.shared.process.SupplierProcess;

public class DeleteDeductionRateProcess extends SupplierProcess<DeductionRate> {

    public DeleteDeductionRateProcess() {
        super("delete_deduction_rate_process");
    }

}
