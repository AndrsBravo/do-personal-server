package com.personal.backoffice.client.commercialplan.add.inputs;

import com.personal.backoffice.client.entities.Client;
import com.personal.backoffice.client.entities.ClientCommercialPlan;
import com.personal.backoffice.commercial.plan.entities.CommercialPlan;
import com.personal.shared.inputs.Input;

public class ClientCommercialPlanInput extends Input {

    private String clientId;
    private String commercialPlanId;

    public ClientCommercialPlanInput() {
        super();
    }

    public void setClientId(String clientTypeId) {
        this.clientId = clientTypeId;
    }

    public void setCommercialPlanId(String commercialPlanId) {
        this.commercialPlanId = commercialPlanId;
    }

    public ClientCommercialPlan getClient() {

        //System.out.println("client_type " + this.clientId);
        var clientCommercialPlan = this.id == null || this.id.isEmpty() ? new ClientCommercialPlan() : new ClientCommercialPlan(this.id);
        clientCommercialPlan.setClient(new Client(this.clientId));
        clientCommercialPlan.setCommercialPlan(new CommercialPlan(this.commercialPlanId));
        clientCommercialPlan.setCreatedBy(sessionUser);
        return clientCommercialPlan;
    }
}
