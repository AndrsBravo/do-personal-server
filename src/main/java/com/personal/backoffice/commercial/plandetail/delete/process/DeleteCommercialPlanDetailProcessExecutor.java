package com.personal.backoffice.commercial.plandetail.delete.process;

import com.personal.backoffice.commercial.plandetail.delete.process.rules.DeleteCommercialPlanDetailRule;
import com.personal.backoffice.commercial.plandetail.entities.CommercialPlanDetail;
import com.personal.shared.process.SupplierProcessExecutor;

public class DeleteCommercialPlanDetailProcessExecutor extends SupplierProcessExecutor<DeleteCommercialPlanDetailProcess, CommercialPlanDetail> {

    public DeleteCommercialPlanDetailProcessExecutor() {
        super(new DeleteCommercialPlanDetailProcess(),
                DeleteCommercialPlanDetailRule::new
        );
    }

    public static DeleteCommercialPlanDetailProcessExecutor builder() {
        return new DeleteCommercialPlanDetailProcessExecutor();
    }

}
