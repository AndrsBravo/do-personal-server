package com.personal.backoffice.commercial.plandetail.create.process.rules;

import com.personal.backoffice.commercial.plandetail.create.process.CreateCommercialPlanDetailProcess;
import com.personal.backoffice.commercial.plandetail.factories.CommercialPlanDetailServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreateCommercialPlanDetailRule implements IProcessRule<CreateCommercialPlanDetailProcess> {

    @Override
    public void apply(CreateCommercialPlanDetailProcess process) {

        var pLogger = LogFactory.builder(CreateCommercialPlanDetailProcess.class, CreateCommercialPlanDetailRule.class);
        var createCommercialPlanDetail = CommercialPlanDetailServiceFactory.CreateCommercialPlanDetail();
        var result = createCommercialPlanDetail.create(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
