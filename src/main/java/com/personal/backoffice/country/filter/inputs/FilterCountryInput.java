package com.personal.backoffice.country.filter.inputs;

import com.personal.shared.inputs.FilterInput;

public class FilterCountryInput extends FilterInput {

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
