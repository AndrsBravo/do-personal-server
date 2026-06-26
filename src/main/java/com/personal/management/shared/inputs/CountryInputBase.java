package com.personal.management.shared.inputs;

import com.personal.management.country.entities.Country;
import com.personal.shared.inputs.Input;

public class CountryInputBase extends Input {

    protected String countryId;

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public Country getCountry() {
        return new Country(countryId);
    }

}
