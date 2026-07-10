package com.personal.backoffice.shared.inputs;

import com.personal.shared.inputs.FilterInput;

public class CountryFilterInputBase extends FilterInput {

    protected String countryId;

    public CountryFilterInputBase() {
        super();
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

}
