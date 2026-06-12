package com.personal.backoffice.commercial.plandetail.filter.process;

import com.personal.backoffice.commercial.plandetail.entities.CommercialPlanDetail;
import com.personal.backoffice.commercial.plandetail.filter.inputs.FilterCommercialPlanDetailInput;
import com.personal.backoffice.commercial.plandetail.filter.process.rules.FilterCommercialPlanDetailRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterCommercialPlanDetailProcessExecutor extends FunctionalProcessExecutor<FilterCommercialPlanDetailProcess, FilterCommercialPlanDetailInput, CommercialPlanDetail> {

    public FilterCommercialPlanDetailProcessExecutor() {
        super(new FilterCommercialPlanDetailProcess(), FilterCommercialPlanDetailRule::new);
    }

    public static FilterCommercialPlanDetailProcessExecutor builder() {
        return new FilterCommercialPlanDetailProcessExecutor();
    }

}
