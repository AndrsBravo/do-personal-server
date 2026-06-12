package com.personal.backoffice.commercial.plan.filter.process.rules;

import com.personal.backoffice.commercial.plan.factories.CommercialPlanServiceFactory;
import com.personal.backoffice.commercial.plan.filter.process.FilterCommercialPlanProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterCommercialPlanRule implements IProcessRule<FilterCommercialPlanProcess> {

    @Override
    public void apply(FilterCommercialPlanProcess process) {

        var pLogger = LogFactory.builder(FilterCommercialPlanProcess.class, FilterCommercialPlanRule.class);
        var query = process.Query();
        var commercialPlanFilter = process.getInitObject();

        if (commercialPlanFilter.getAll() != null) {
            query.Field("id", "");
            query.Where().AndNotEmpty("id");
        }

        if (commercialPlanFilter.getId() != null) {
            query.Field("id", commercialPlanFilter.getId());
            query.Where().AndEqu("id");
        }

        if (commercialPlanFilter.getType() != null) {
            query.Field("cp_plan", commercialPlanFilter.getType());
            query.Where().AndEqu("cp_plan");
        }

        var filterCommercialPlan = CommercialPlanServiceFactory.FilterCommercialPlan();

        var result = filterCommercialPlan.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Types", "Filtered user types with properties: " + query.getKeyPair()));
    }

}
