package com.personal.shared.inputs;

import com.personal.shared.query.field.FieldFilter;

public class FilterInput {

    private FieldFilter<String> id;

    public FieldFilter<String> getId() {
        return id;
    }

    public void setId(FieldFilter<String> id) {
        this.id = id;
    }

}
