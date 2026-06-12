package com.personal.business.benefitrate.create.process.rules;

import com.personal.business.benefitrate.create.process.CreateBenefitRateProcess;
import com.personal.business.benefitrate.factories.BenefitRateServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreateBenefitRateRule implements IProcessRule<CreateBenefitRateProcess> {

    @Override
    public void apply(CreateBenefitRateProcess process) {

        var pLogger = LogFactory.builder(CreateBenefitRateProcess.class, CreateBenefitRateRule.class);
        var benefitRate = process.getInitObject();
        var createBenefitRate = BenefitRateServiceFactory.CreateBenefitRate(benefitRate.getBusiness().getDbName());
        var result = createBenefitRate.create(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
