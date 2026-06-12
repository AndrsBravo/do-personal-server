package com.personal.business.benefit.create.process.rules;

import com.personal.business.benefit.create.process.CreateBenefitProcess;
import com.personal.business.benefit.factories.BenefitServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreateBenefitRule implements IProcessRule<CreateBenefitProcess> {

    @Override
    public void apply(CreateBenefitProcess process) {

        var pLogger = LogFactory.builder(CreateBenefitProcess.class, CreateBenefitRule.class);
        var benefit = process.getInitObject();
        var createBenefit = BenefitServiceFactory.CreateBenefit(benefit.getBusiness().getDbName());
        var result = createBenefit.create(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
