package com.personal.backoffice.commercial.plandetail.filter.process;

import com.personal.backoffice.commercial.plandetail.entities.CommercialPlanDetail;
import com.personal.backoffice.commercial.plandetail.filter.inputs.FilterCommercialPlanDetailInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterCommercialPlanDetailProcess extends FunctionalProcess<FilterCommercialPlanDetailInput, CommercialPlanDetail> {

    public FilterCommercialPlanDetailProcess() {
        super("filter_commercial_plan_detail");
    }

}
