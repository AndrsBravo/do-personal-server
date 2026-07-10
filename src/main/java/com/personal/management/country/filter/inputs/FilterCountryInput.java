package com.personal.management.country.filter.inputs;

import com.personal.backoffice.shared.inputs.CountryFilterInputBase;

public class FilterCountryInput extends CountryFilterInputBase {

    private String name;
    private String code;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
