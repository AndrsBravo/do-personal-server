package com.personal.management.deductionrate.update.process;

import com.personal.management.deductionrate.entities.DeductionRate;
import com.personal.management.deductionrate.update.process.rules.UpdateFieldsParamsDeductionRateRule;
import com.personal.management.deductionrate.update.process.rules.UpdateDeductionRateRule;
import com.personal.shared.process.SupplierProcessExecutor;

public class UpdateDeductionRateProcessExecutor extends SupplierProcessExecutor<UpdateDeductionRateProcess, DeductionRate> {

    public UpdateDeductionRateProcessExecutor() {
        super(new UpdateDeductionRateProcess(),
                UpdateFieldsParamsDeductionRateRule::new,
                UpdateDeductionRateRule::new
        );
    }

    public static UpdateDeductionRateProcessExecutor builder() {
        return new UpdateDeductionRateProcessExecutor();
    }

}
