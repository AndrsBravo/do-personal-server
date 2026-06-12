package com.personal.backoffice.client.commercialplan.add.process;

import com.personal.backoffice.client.commercialplan.add.process.rules.AddClientCommercialPlanRule;
import com.personal.backoffice.client.commercialplan.add.process.rules.ValidateClientCommercialPlanRule;
import com.personal.backoffice.client.entities.ClientCommercialPlan;
import com.personal.shared.process.SupplierProcessExecutor;

public class AddClientCommercialPlanProcessExecutor extends SupplierProcessExecutor<AddClientCommercialPlanProcess, ClientCommercialPlan> {

    public AddClientCommercialPlanProcessExecutor() {
        super(new AddClientCommercialPlanProcess(),
                ValidateClientCommercialPlanRule::new,
                AddClientCommercialPlanRule::new
        );
    }

    public static AddClientCommercialPlanProcessExecutor builder() {
        return new AddClientCommercialPlanProcessExecutor();
    }

}
