package com.personal.backoffice.country.create.inputs;

import com.personal.backoffice.country.entities.Country;
import com.personal.shared.inputs.Input;

public class CountryInput extends Input {

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
