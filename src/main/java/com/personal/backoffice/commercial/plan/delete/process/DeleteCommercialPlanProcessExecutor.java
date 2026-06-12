package com.personal.backoffice.commercial.plan.delete.process;

import com.personal.backoffice.commercial.plan.delete.process.rules.DeleteCommercialPlanRule;
import com.personal.backoffice.commercial.plan.entities.CommercialPlan;
import com.personal.shared.process.SupplierProcessExecutor;

public class DeleteCommercialPlanProcessExecutor extends SupplierProcessExecutor<DeleteCommercialPlanProcess, CommercialPlan> {

    public DeleteCommercialPlanProcessExecutor() {
        super(new DeleteCommercialPlanProcess(),
                DeleteCommercialPlanRule::new
        );
    }

    public static DeleteCommercialPlanProcessExecutor builder() {
        return new DeleteCommercialPlanProcessExecutor();
    }

}
