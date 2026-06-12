package com.personal.backoffice.client.commercialplan.filter.process;

import com.personal.backoffice.client.commercialplan.filter.inputs.FilterClientCommercialPlanInput;
import com.personal.backoffice.client.entities.ClientCommercialPlan;
import com.personal.shared.process.FunctionalProcess;

public class FilterClientCommercialPlanProcess extends FunctionalProcess<FilterClientCommercialPlanInput, ClientCommercialPlan> {

    public FilterClientCommercialPlanProcess() {
        super("filter_client_commercial_plan_process");
    }

}
