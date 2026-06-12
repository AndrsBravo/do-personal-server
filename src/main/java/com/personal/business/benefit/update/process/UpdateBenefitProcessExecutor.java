package com.personal.business.benefit.update.process;

import com.personal.business.benefit.entities.Benefit;
import com.personal.business.benefit.update.process.rules.UpdateFieldsParamsBenefitRule;
import com.personal.business.benefit.update.process.rules.UpdateBenefitRule;
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
