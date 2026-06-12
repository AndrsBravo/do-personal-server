package com.personal.backoffice.commercial.plandetail.update.process.rules;

import com.personal.backoffice.commercial.plandetail.factories.CommercialPlanDetailServiceFactory;
import com.personal.backoffice.commercial.plandetail.update.process.UpdateCommercialPlanDetailProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateCommercialPlanDetailRule implements IProcessRule<UpdateCommercialPlanDetailProcess> {

    @Override
    public void apply(UpdateCommercialPlanDetailProcess process) {

        var pLogger = LogFactory.builder(UpdateCommercialPlanDetailProcess.class, UpdateCommercialPlanDetailRule.class);
        var createCommercialPlanDetail = CommercialPlanDetailServiceFactory.EditCommercialPlanDetail();
        var result = createCommercialPlanDetail.edit(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
