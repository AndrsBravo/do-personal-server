package com.personal.shared.entities;

import com.personal.backoffice.business.entities.Business;

public abstract class BusinessEntity extends BaseEntity {

    private Business business;

    public BusinessEntity() {
        super();
    }

    public BusinessEntity(String id) {
        super(id);
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

}
