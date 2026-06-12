package com.personal.shared.inputs;

import com.personal.backoffice.business.entities.Business;

public class BusinessFilterInput extends FilterInput {

    private Business business;

    public BusinessFilterInput() {
        super();
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public Business getBusiness() {
        return business;
    }

}
