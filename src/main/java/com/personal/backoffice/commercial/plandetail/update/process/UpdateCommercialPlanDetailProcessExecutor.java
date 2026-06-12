package com.personal.backoffice.commercial.plandetail.update.process;

import com.personal.backoffice.commercial.plandetail.entities.CommercialPlanDetail;
import com.personal.backoffice.commercial.plandetail.update.process.rules.UpdateCommercialPlanDetailRule;
import com.personal.backoffice.commercial.plandetail.update.process.rules.UpdateFieldsParamsCommercialPlanDetailRule;
import com.personal.shared.process.SupplierProcessExecutor;

public class UpdateCommercialPlanDetailProcessExecutor extends SupplierProcessExecutor<UpdateCommercialPlanDetailProcess, CommercialPlanDetail> {

    public UpdateCommercialPlanDetailProcessExecutor() {
        super(new UpdateCommercialPlanDetailProcess(),
                UpdateFieldsParamsCommercialPlanDetailRule::new,
                UpdateCommercialPlanDetailRule::new
        );
    }

    public static UpdateCommercialPlanDetailProcessExecutor builder() {
        return new UpdateCommercialPlanDetailProcessExecutor();
    }

}
