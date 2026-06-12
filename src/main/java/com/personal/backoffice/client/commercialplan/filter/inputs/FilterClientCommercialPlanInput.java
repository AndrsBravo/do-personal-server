package com.personal.backoffice.client.commercialplan.filter.inputs;

import com.personal.shared.inputs.FilterInput;

public class FilterClientCommercialPlanInput extends FilterInput {

    private String clientId;
    private String commercialPlanId;

    public FilterClientCommercialPlanInput() {
        super();
    }

    public void setClientId(String clientTypeId) {
        this.clientId = clientTypeId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setCommercialPlanId(String commercialPlanId) {
        this.commercialPlanId = commercialPlanId;
    }

    public String getCommercialPlanId() {
        return commercialPlanId;
    }

}
