package com.personal.backoffice.shared.inputs;

import com.personal.shared.core.entities.SharedCountry;
import com.personal.shared.inputs.Input;

public class CountryInputBase extends Input {

    protected String countryId;

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public SharedCountry getCountry() {
        return new SharedCountry(countryId);
    }

}
