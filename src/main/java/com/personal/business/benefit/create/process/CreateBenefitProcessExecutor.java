package com.personal.business.benefit.create.process;

import com.personal.business.benefit.create.process.rules.CreateBenefitRule;
import com.personal.business.benefit.create.process.rules.ValidateBenefitRule;
import com.personal.business.benefit.entities.Benefit;
import com.personal.shared.process.SupplierProcessExecutor;

public class CreateBenefitProcessExecutor extends SupplierProcessExecutor<CreateBenefitProcess, Benefit> {

    public CreateBenefitProcessExecutor() {
        super(new CreateBenefitProcess(),
                ValidateBenefitRule::new,
                CreateBenefitRule::new
        );
    }

    public static CreateBenefitProcessExecutor builder() {
        return new CreateBenefitProcessExecutor();
    }

}
