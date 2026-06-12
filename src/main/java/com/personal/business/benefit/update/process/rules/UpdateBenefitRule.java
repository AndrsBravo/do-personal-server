package com.personal.business.benefit.update.process.rules;

import com.personal.business.benefit.factories.BenefitServiceFactory;
import com.personal.business.benefit.update.process.UpdateBenefitProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateBenefitRule implements IProcessRule<UpdateBenefitProcess> {

    @Override
    public void apply(UpdateBenefitProcess process) {

        var pLogger = LogFactory.builder(UpdateBenefitProcess.class, UpdateBenefitRule.class);
        var benefit = process.getInitObject();
        var createBenefit = BenefitServiceFactory.EditBenefit(benefit.getBusiness().getDbName());
        var result = createBenefit.edit(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
