package com.personal.backoffice.commercial.plan.create.process.rules;

import com.personal.backoffice.commercial.plan.create.process.CreateCommercialPlanProcess;
import com.personal.backoffice.commercial.plan.factories.CommercialPlanServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreateCommercialPlanRule implements IProcessRule<CreateCommercialPlanProcess> {

    @Override
    public void apply(CreateCommercialPlanProcess process) {

        var pLogger = LogFactory.builder(CreateCommercialPlanProcess.class, CreateCommercialPlanRule.class);
        var createCommercialPlan = CommercialPlanServiceFactory.CreateCommercialPlan();
        var result = createCommercialPlan.create(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
