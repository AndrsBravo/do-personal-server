package com.personal.business.deductionrate.delete.process;

import com.personal.business.deductionrate.delete.process.rules.DeleteDeductionRateRule;
import com.personal.business.deductionrate.entities.DeductionRate;
import com.personal.shared.process.SupplierProcessExecutor;

public class DeleteDeductionRateProcessExecutor extends SupplierProcessExecutor<DeleteDeductionRateProcess, DeductionRate> {

    public DeleteDeductionRateProcessExecutor() {
        super(new DeleteDeductionRateProcess(),
                DeleteDeductionRateRule::new
        );
    }

    public static DeleteDeductionRateProcessExecutor builder() {
        return new DeleteDeductionRateProcessExecutor();
    }

}
