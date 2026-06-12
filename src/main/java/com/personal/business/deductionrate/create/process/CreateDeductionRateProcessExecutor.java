package com.personal.business.deductionrate.create.process;

import com.personal.business.deductionrate.create.process.rules.CreateDeductionRateRule;
import com.personal.business.deductionrate.create.process.rules.ValidateDeductionRateRule;
import com.personal.business.deductionrate.entities.DeductionRate;
import com.personal.shared.process.SupplierProcessExecutor;

public class CreateDeductionRateProcessExecutor extends SupplierProcessExecutor<CreateDeductionRateProcess, DeductionRate> {

    public CreateDeductionRateProcessExecutor() {
        super(new CreateDeductionRateProcess(),
                ValidateDeductionRateRule::new,
                CreateDeductionRateRule::new
        );
    }

    public static CreateDeductionRateProcessExecutor builder() {
        return new CreateDeductionRateProcessExecutor();
    }

}
