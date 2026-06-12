package com.personal.backoffice.commercial.plan.create.process;

import com.personal.backoffice.commercial.plan.create.process.rules.CreateCommercialPlanRule;
import com.personal.backoffice.commercial.plan.create.process.rules.ValidateCommercialPlanRule;
import com.personal.backoffice.commercial.plan.entities.CommercialPlan;
import com.personal.shared.process.SupplierProcessExecutor;

public class CreateCommercialPlanProcessExecutor extends SupplierProcessExecutor<CreateCommercialPlanProcess, CommercialPlan> {

    public CreateCommercialPlanProcessExecutor() {
        super(new CreateCommercialPlanProcess(),
                ValidateCommercialPlanRule::new,
                CreateCommercialPlanRule::new
        );
    }

    public static CreateCommercialPlanProcessExecutor builder() {
        return new CreateCommercialPlanProcessExecutor();
    }

}
