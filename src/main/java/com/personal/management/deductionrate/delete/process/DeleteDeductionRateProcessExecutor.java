package com.personal.management.deductionrate.delete.process;

import com.personal.management.deductionrate.delete.process.rules.DeleteDeductionRateRule;
import com.personal.management.deductionrate.entities.DeductionRate;
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
