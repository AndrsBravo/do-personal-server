package com.personal.shared.inputs;

import com.personal.backoffice.business.entities.Business;

public class BusinessInputBase extends Input {

    private String business_id;

    public BusinessInputBase() {
        super();
    }

    public void setBusinessId(String business_id) {
        this.business_id = business_id;
    }

    public Business getBusiness() {
        return new Business(this.business_id);
    }

}
