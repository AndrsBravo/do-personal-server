package com.personal.backoffice.client.commercialplan.filter.process.rules;

import com.personal.backoffice.client.commercialplan.filter.process.FilterClientCommercialPlanProcess;
import com.personal.backoffice.client.factories.ClientServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterClientCommercialPlanRule implements IProcessRule<FilterClientCommercialPlanProcess> {

    @Override
    public void apply(FilterClientCommercialPlanProcess process) {

        var pLogger = LogFactory.builder(FilterClientCommercialPlanProcess.class, FilterClientCommercialPlanRule.class);
        var query = process.Query();
        var clientCommercialPlanFilter = process.getInitObject();

        if (clientCommercialPlanFilter.getId() != null) {
            query.Field("id", clientCommercialPlanFilter.getId());
            query.Where().Field("id", clientCommercialPlanFilter.getId());
        }

        if (clientCommercialPlanFilter.getClientId() != null) {
            query.Field("client_id", clientCommercialPlanFilter.getClientId());
            query.Where().AndEqu("client_id");
        }
        if (clientCommercialPlanFilter.getCommercialPlanId() != null) {
            query.Field("commercial_plan_id", clientCommercialPlanFilter.getCommercialPlanId());
            query.Where().AndEqu("commercial_plan_id");
        }

        var filterCommercialPlan = ClientServiceFactory.FilterClientCommercialPlan();

        var result = filterCommercialPlan.filter(query);
        process.setResult(result.getResult());

        process.addLog(pLogger.INFO("Filtrar Planes Comerciales de Clientes", "Planes Comerciales de Clientes filtrados con éxito"));

    }

}
