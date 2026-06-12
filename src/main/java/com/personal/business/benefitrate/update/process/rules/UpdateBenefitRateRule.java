package com.personal.business.benefitrate.update.process.rules;

import com.personal.business.benefitrate.factories.BenefitRateServiceFactory;
import com.personal.business.benefitrate.update.process.UpdateBenefitRateProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateBenefitRateRule implements IProcessRule<UpdateBenefitRateProcess> {

    @Override
    public void apply(UpdateBenefitRateProcess process) {

        var pLogger = LogFactory.builder(UpdateBenefitRateProcess.class, UpdateBenefitRateRule.class);
        var benefitRate = process.getInitObject();
        var createBenefitRate = BenefitRateServiceFactory.EditBenefitRate(benefitRate.getBusiness().getDbName());
        var result = createBenefitRate.edit(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
