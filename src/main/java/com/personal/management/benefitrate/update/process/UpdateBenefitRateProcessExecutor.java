package com.personal.management.benefitrate.update.process;

import com.personal.management.benefitrate.entities.BenefitRate;
import com.personal.management.benefitrate.update.process.rules.UpdateFieldsParamsBenefitRateRule;
import com.personal.management.benefitrate.update.process.rules.UpdateBenefitRateRule;
import com.personal.shared.process.SupplierProcessExecutor;

public class UpdateBenefitRateProcessExecutor extends SupplierProcessExecutor<UpdateBenefitRateProcess, BenefitRate> {

    public UpdateBenefitRateProcessExecutor() {
        super(new UpdateBenefitRateProcess(),
                UpdateFieldsParamsBenefitRateRule::new,
                UpdateBenefitRateRule::new
        );
    }

    public static UpdateBenefitRateProcessExecutor builder() {
        return new UpdateBenefitRateProcessExecutor();
    }

}
