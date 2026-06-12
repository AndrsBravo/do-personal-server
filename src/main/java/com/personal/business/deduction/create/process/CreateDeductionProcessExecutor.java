package com.personal.business.deduction.create.process;

import com.personal.business.deduction.create.process.rules.CreateDeductionRule;
import com.personal.business.deduction.create.process.rules.ValidateDeductionRule;
import com.personal.business.deduction.entities.Deduction;
import com.personal.shared.process.SupplierProcessExecutor;

public class CreateDeductionProcessExecutor extends SupplierProcessExecutor<CreateDeductionProcess, Deduction> {

    public CreateDeductionProcessExecutor() {
        super(new CreateDeductionProcess(),
                ValidateDeductionRule::new,
                CreateDeductionRule::new
        );
    }

    public static CreateDeductionProcessExecutor builder() {
        return new CreateDeductionProcessExecutor();
    }

}
