package com.personal.business.benefitrate.delete.process;

import com.personal.business.benefitrate.entities.BenefitRate;
import com.personal.shared.process.SupplierProcess;

public class DeleteBenefitRateProcess extends SupplierProcess<BenefitRate> {

    public DeleteBenefitRateProcess() {
        super("delete_benefit_rate_process");
    }

}
