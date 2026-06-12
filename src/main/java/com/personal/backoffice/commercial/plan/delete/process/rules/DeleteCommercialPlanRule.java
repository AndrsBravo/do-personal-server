package com.personal.backoffice.commercial.plan.delete.process.rules;

import com.personal.backoffice.commercial.plan.delete.process.DeleteCommercialPlanProcess;
import com.personal.backoffice.commercial.plan.factories.CommercialPlanServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class DeleteCommercialPlanRule implements IProcessRule<DeleteCommercialPlanProcess> {

    @Override
    public void apply(DeleteCommercialPlanProcess process) {

        var pLogger = LogFactory.builder(DeleteCommercialPlanProcess.class, DeleteCommercialPlanRule.class);

        var query = process.Query();
        var commercialPlan = process.getInitObject();

        query.Field("id", commercialPlan.getId());
        query.Where().Equ("id");

        var createCommercialPlan = CommercialPlanServiceFactory.DeleteCommercialPlan();
        var result = createCommercialPlan.delete(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Eliminar Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Eliminar Tipo de Usuario", "Tipo de Usuario eliminado con éxito"));

    }

}
