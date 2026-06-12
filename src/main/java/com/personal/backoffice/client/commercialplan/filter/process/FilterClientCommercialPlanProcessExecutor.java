package com.personal.backoffice.client.commercialplan.filter.process;

import com.personal.backoffice.client.commercialplan.filter.inputs.FilterClientCommercialPlanInput;
import com.personal.backoffice.client.commercialplan.filter.process.rules.FilterClientCommercialPlanRule;
import com.personal.backoffice.client.entities.ClientCommercialPlan;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterClientCommercialPlanProcessExecutor extends FunctionalProcessExecutor<FilterClientCommercialPlanProcess, FilterClientCommercialPlanInput, ClientCommercialPlan> {

    public FilterClientCommercialPlanProcessExecutor() {
        super(new FilterClientCommercialPlanProcess(),
                FilterClientCommercialPlanRule::new
        );
    }

    public static FilterClientCommercialPlanProcessExecutor builder() {
        return new FilterClientCommercialPlanProcessExecutor();
    }

}
