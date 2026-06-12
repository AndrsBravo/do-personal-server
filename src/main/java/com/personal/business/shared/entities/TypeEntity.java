package com.personal.business.shared.entities;

import com.personal.backoffice.business.entities.Business;
import com.personal.shared.entities.TypeEntityBase;

public class TypeEntity extends TypeEntityBase {

    private Business business;

    public TypeEntity() {
        super();
    }

    public TypeEntity(String id) {
        super(id);

    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

}
