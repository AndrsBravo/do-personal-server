package com.personal.backoffice.commercial.plan.filter.process;

import com.personal.backoffice.commercial.plan.entities.CommercialPlan;
import com.personal.backoffice.commercial.plan.filter.inputs.FilterCommercialPlanInput;
import com.personal.backoffice.commercial.plan.filter.process.rules.FilterCommercialPlanRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterCommercialPlanProcessExecutor extends FunctionalProcessExecutor<FilterCommercialPlanProcess, FilterCommercialPlanInput, CommercialPlan> {

    public FilterCommercialPlanProcessExecutor() {
        super(new FilterCommercialPlanProcess(), FilterCommercialPlanRule::new);
    }

    public static FilterCommercialPlanProcessExecutor builder() {
        return new FilterCommercialPlanProcessExecutor();
    }

}
