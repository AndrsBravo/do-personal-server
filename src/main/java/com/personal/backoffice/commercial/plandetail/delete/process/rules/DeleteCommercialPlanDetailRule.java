package com.personal.backoffice.commercial.plandetail.delete.process.rules;

import com.personal.backoffice.commercial.plandetail.delete.process.DeleteCommercialPlanDetailProcess;
import com.personal.backoffice.commercial.plandetail.factories.CommercialPlanDetailServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class DeleteCommercialPlanDetailRule implements IProcessRule<DeleteCommercialPlanDetailProcess> {

    @Override
    public void apply(DeleteCommercialPlanDetailProcess process) {

        var pLogger = LogFactory.builder(DeleteCommercialPlanDetailProcess.class, DeleteCommercialPlanDetailRule.class);

        var query = process.Query();
        var commercialPlan = process.getInitObject();

        query.Field("id", commercialPlan.getId());
        query.Where().Equ("id");

        var createCommercialPlanDetail = CommercialPlanDetailServiceFactory.DeleteCommercialPlanDetail();
        var result = createCommercialPlanDetail.delete(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Eliminar Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Eliminar Tipo de Usuario", "Tipo de Usuario eliminado con éxito"));

    }

}
