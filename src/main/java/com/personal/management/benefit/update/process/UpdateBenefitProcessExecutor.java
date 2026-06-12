package com.personal.management.benefit.update.process;

import com.personal.management.benefit.entities.Benefit;
import com.personal.management.benefit.update.process.rules.UpdateFieldsParamsBenefitRule;
import com.personal.management.benefit.update.process.rules.UpdateBenefitRule;
import com.personal.shared.process.SupplierProcessExecutor;

public class UpdateBenefitProcessExecutor extends SupplierProcessExecutor<UpdateBenefitProcess, Benefit> {

    public UpdateBenefitProcessExecutor() {
        super(new UpdateBenefitProcess(),
                UpdateFieldsParamsBenefitRule::new,
                UpdateBenefitRule::new
        );
    }

    public static UpdateBenefitProcessExecutor builder() {
        return new UpdateBenefitProcessExecutor();
    }

}
