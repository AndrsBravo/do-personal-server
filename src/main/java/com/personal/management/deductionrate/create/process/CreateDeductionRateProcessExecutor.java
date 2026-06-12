package com.personal.management.deductionrate.create.process;

import com.personal.management.deductionrate.create.process.rules.CreateDeductionRateRule;
import com.personal.management.deductionrate.create.process.rules.ValidateDeductionRateRule;
import com.personal.management.deductionrate.entities.DeductionRate;
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
