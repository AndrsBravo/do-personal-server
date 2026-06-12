package com.personal.business.origincategory.entities;

import com.personal.backoffice.business.entities.Business;
import com.personal.shared.core.entities.SharedOriginCategory;

public class OriginCategory extends SharedOriginCategory {

    private Business business;

    public OriginCategory() {
        super();
    }

    public OriginCategory(String id) {
        super(id);
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

}
