package com.personal.business.deductionrate.update.process;

import com.personal.business.deductionrate.entities.DeductionRate;
import com.personal.business.deductionrate.update.process.rules.UpdateDeductionRateRule;
import com.personal.business.deductionrate.update.process.rules.UpdateFieldsParamsDeductionRateRule;
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
