package com.personal.management.financecategory.entities;

import com.personal.management.country.entities.Country;
import com.personal.shared.core.entities.SharedFinanceCategory;

public class FinanceCategory extends SharedFinanceCategory {

    private Country country;

    public FinanceCategory() {
        super();
    }

    public FinanceCategory(String id) {
        super(id);
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

}
