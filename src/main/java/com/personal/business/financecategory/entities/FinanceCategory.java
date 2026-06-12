package com.personal.business.financecategory.entities;

import com.personal.backoffice.business.entities.Business;
import com.personal.shared.core.entities.SharedFinanceCategory;

public class FinanceCategory extends SharedFinanceCategory {

    private Business business;

    public FinanceCategory() {
        super();
    }

    public FinanceCategory(String id) {
        super(id);
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

}
