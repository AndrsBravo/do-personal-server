package com.personal.management.benefitrate.delete.process;

import com.personal.management.benefitrate.entities.BenefitRate;
import com.personal.shared.process.SupplierProcess;

public class DeleteBenefitRateProcess extends SupplierProcess<BenefitRate> {

    public DeleteBenefitRateProcess() {
        super("delete_benefit_rate_process");
    }

}
