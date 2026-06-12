package com.personal.management.country.create.inputs;

import com.personal.management.country.entities.Country;
import com.personal.management.shared.inputs.CountryInputBase;

public class CountryInput extends CountryInputBase {

    private String name;
    private String code;

    public CountryInput() {
        super();
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        var country = this.id == null || this.id.isEmpty() ? new Country() : new Country(this.id);
        country.setName(name);
        country.setCode(code);
        country.setCreatedBy(sessionUser);
        return country;
    }
}
