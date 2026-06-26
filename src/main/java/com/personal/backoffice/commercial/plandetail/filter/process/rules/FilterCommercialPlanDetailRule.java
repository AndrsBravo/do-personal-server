package com.personal.backoffice.commercial.plandetail.filter.process.rules;

import com.personal.backoffice.commercial.plandetail.factories.CommercialPlanDetailServiceFactory;
import com.personal.backoffice.commercial.plandetail.filter.process.FilterCommercialPlanDetailProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterCommercialPlanDetailRule implements IProcessRule<FilterCommercialPlanDetailProcess> {

    @Override
    public void apply(FilterCommercialPlanDetailProcess process) {

        var pLogger = LogFactory.builder(FilterCommercialPlanDetailProcess.class, FilterCommercialPlanDetailRule.class);
        var query = process.Query();
        var commercialPlanDetailFilter = process.getInitObject();

        if (commercialPlanDetailFilter.getId() != null) {
            query.Field("id", commercialPlanDetailFilter.getId());
            query.Where().Field("id", commercialPlanDetailFilter.getId());
        }

        if (commercialPlanDetailFilter.getType() != null) {
            query.Field("commercial_plan_id", commercialPlanDetailFilter.getType());
            query.Where().AndEqu("commercial_plan_id");
        }

        var filterCommercialPlanDetail = CommercialPlanDetailServiceFactory.FilterCommercialPlanDetail();

        var result = filterCommercialPlanDetail.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Types", "Filtered user types with properties: " + query.getKeyPair()));
    }

}
