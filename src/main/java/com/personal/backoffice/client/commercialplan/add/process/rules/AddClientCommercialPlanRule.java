package com.personal.backoffice.client.commercialplan.add.process.rules;

import com.personal.backoffice.client.commercialplan.add.process.AddClientCommercialPlanProcess;
import com.personal.backoffice.client.factories.ClientServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class AddClientCommercialPlanRule implements IProcessRule<AddClientCommercialPlanProcess> {

    @Override
    public void apply(AddClientCommercialPlanProcess process) {

        var pLogger = LogFactory.builder(AddClientCommercialPlanProcess.class, AddClientCommercialPlanRule.class);
        var addClientCommercialPlan = ClientServiceFactory.AddClientCommercialPlan();
        var result = addClientCommercialPlan.create(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Plan Comercial del Cliente", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Plan Comercial del Cliente", "Plan Comercial del Cliente creado con éxito"));

    }

}
