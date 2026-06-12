package com.personal.business.deductionrate.delete.process;

import com.personal.business.deductionrate.entities.DeductionRate;
import com.personal.shared.process.SupplierProcess;

public class DeleteDeductionRateProcess extends SupplierProcess<DeductionRate> {

    public DeleteDeductionRateProcess() {
        super("delete_deduction_rate_process");
    }

}
