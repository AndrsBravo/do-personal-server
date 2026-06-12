package com.personal.business.benefitrate.delete.process;

import com.personal.business.benefitrate.delete.process.rules.DeleteBenefitRateRule;
import com.personal.business.benefitrate.entities.BenefitRate;
import com.personal.shared.process.SupplierProcessExecutor;

public class DeleteBenefitRateProcessExecutor extends SupplierProcessExecutor<DeleteBenefitRateProcess, BenefitRate> {

    public DeleteBenefitRateProcessExecutor() {
        super(new DeleteBenefitRateProcess(),
                DeleteBenefitRateRule::new
        );
    }

    public static DeleteBenefitRateProcessExecutor builder() {
        return new DeleteBenefitRateProcessExecutor();
    }

}
