package com.personal.shared.inputs;

import com.personal.backoffice.business.entities.Business;

public class BusinessInputBase extends Input {

    private Business business;

    public BusinessInputBase() {
        super();
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public Business getBusiness() {
        return business;
    }

}
