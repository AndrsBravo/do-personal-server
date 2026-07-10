package com.personal.management.financecategory.entities;

import com.personal.shared.core.entities.SharedCountry;
import com.personal.shared.core.entities.SharedFinanceCategory;

public class FinanceCategory extends SharedFinanceCategory {

    private SharedCountry country;

    public FinanceCategory() {
        super();
    }

    public FinanceCategory(String id) {
        super(id);
    }

    public SharedCountry getCountry() {
        return country;
    }

    public void setCountry(SharedCountry country) {
        this.country = country;
    }

}
