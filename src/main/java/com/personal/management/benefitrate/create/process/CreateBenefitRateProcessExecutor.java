package com.personal.management.benefitrate.create.process;

import com.personal.management.benefitrate.create.process.rules.CreateBenefitRateRule;
import com.personal.management.benefitrate.create.process.rules.ValidateBenefitRateRule;
import com.personal.management.benefitrate.entities.BenefitRate;
import com.personal.shared.process.SupplierProcessExecutor;

public class CreateBenefitRateProcessExecutor extends SupplierProcessExecutor<CreateBenefitRateProcess, BenefitRate> {

    public CreateBenefitRateProcessExecutor() {
        super(new CreateBenefitRateProcess(),
                ValidateBenefitRateRule::new,
                CreateBenefitRateRule::new
        );
    }

    public static CreateBenefitRateProcessExecutor builder() {
        return new CreateBenefitRateProcessExecutor();
    }

}
