package com.personal.backoffice.commercial.plan.update.process;

import com.personal.backoffice.commercial.plan.entities.CommercialPlan;
import com.personal.backoffice.commercial.plan.update.process.rules.UpdateCommercialPlanRule;
import com.personal.backoffice.commercial.plan.update.process.rules.UpdateFieldsParamsCommercialPlanRule;
import com.personal.shared.process.SupplierProcessExecutor;

public class UpdateCommercialPlanProcessExecutor extends SupplierProcessExecutor<UpdateCommercialPlanProcess, CommercialPlan> {

    public UpdateCommercialPlanProcessExecutor() {
        super(new UpdateCommercialPlanProcess(),
                UpdateFieldsParamsCommercialPlanRule::new,
                UpdateCommercialPlanRule::new
        );
    }

    public static UpdateCommercialPlanProcessExecutor builder() {
        return new UpdateCommercialPlanProcessExecutor();
    }

}
