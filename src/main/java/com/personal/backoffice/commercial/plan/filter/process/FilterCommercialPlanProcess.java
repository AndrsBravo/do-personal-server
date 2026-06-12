package com.personal.backoffice.commercial.plan.filter.process;

import com.personal.backoffice.commercial.plan.entities.CommercialPlan;
import com.personal.backoffice.commercial.plan.filter.inputs.FilterCommercialPlanInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterCommercialPlanProcess extends FunctionalProcess<FilterCommercialPlanInput, CommercialPlan> {

    public FilterCommercialPlanProcess() {
        super("filter_commercial_plan");
    }

}
