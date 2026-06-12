package com.personal.backoffice.commercial.plan.update.process.rules;

import com.personal.backoffice.commercial.plan.factories.CommercialPlanServiceFactory;
import com.personal.backoffice.commercial.plan.update.process.UpdateCommercialPlanProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateCommercialPlanRule implements IProcessRule<UpdateCommercialPlanProcess> {

    @Override
    public void apply(UpdateCommercialPlanProcess process) {

        var pLogger = LogFactory.builder(UpdateCommercialPlanProcess.class, UpdateCommercialPlanRule.class);
        var createCommercialPlan = CommercialPlanServiceFactory.EditCommercialPlan();
        var result = createCommercialPlan.edit(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
