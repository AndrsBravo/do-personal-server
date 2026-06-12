package com.personal.backoffice.client.entities;

import com.personal.backoffice.commercial.plan.entities.CommercialPlan;
import com.personal.shared.entities.ClientEntity;

public class ClientCommercialPlan extends ClientEntity {

    private CommercialPlan commercialPlan;

    public ClientCommercialPlan() {
        super();
    }

    public ClientCommercialPlan(String id) {
        super(id);
    }

    public CommercialPlan getCommercialPlan() {
        return commercialPlan;
    }

    public void setCommercialPlan(CommercialPlan commercialPlan) {
        this.commercialPlan = commercialPlan;
    }
}
