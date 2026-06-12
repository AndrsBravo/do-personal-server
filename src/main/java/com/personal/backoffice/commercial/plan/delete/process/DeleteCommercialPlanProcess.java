package com.personal.backoffice.commercial.plan.delete.process;

import com.personal.backoffice.commercial.plan.entities.CommercialPlan;
import com.personal.shared.process.SupplierProcess;

public class DeleteCommercialPlanProcess extends SupplierProcess<CommercialPlan> {

    public DeleteCommercialPlanProcess() {
        super("delete_commercial_plan_process");
    }

}
