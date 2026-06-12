package com.personal.backoffice.commercial.plandetail.create.process;

import com.personal.backoffice.commercial.plandetail.create.process.rules.CreateCommercialPlanDetailRule;
import com.personal.backoffice.commercial.plandetail.create.process.rules.ValidateCommercialPlanDetailRule;
import com.personal.backoffice.commercial.plandetail.entities.CommercialPlanDetail;
import com.personal.shared.process.SupplierProcessExecutor;

public class CreateCommercialPlanDetailProcessExecutor extends SupplierProcessExecutor<CreateCommercialPlanDetailProcess, CommercialPlanDetail> {

    public CreateCommercialPlanDetailProcessExecutor() {
        super(new CreateCommercialPlanDetailProcess(),
                ValidateCommercialPlanDetailRule::new,
                CreateCommercialPlanDetailRule::new
        );
    }

    public static CreateCommercialPlanDetailProcessExecutor builder() {
        return new CreateCommercialPlanDetailProcessExecutor();
    }

}
