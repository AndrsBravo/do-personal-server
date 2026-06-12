package com.personal.business.shared.inputs;

import com.personal.backoffice.business.entities.Business;
import com.personal.shared.inputs.FilterInput;

public class BusinessFilterInputBase extends FilterInput {

    private String businessId;
    private Business business;

    public BusinessFilterInputBase() {
        super();
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public Business getBusiness() {
        if (business == null) {
            business = new Business(this.businessId);
        }
        return business;
    }

}
