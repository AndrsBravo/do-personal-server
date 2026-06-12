package com.personal.backoffice.client.filter.inputs;

import com.personal.shared.inputs.FilterInput;

public class FilterClientInput extends FilterInput {

    private String clientTypeId;

    public FilterClientInput() {
        super();
    }

    public void setType(String type) {
        this.clientTypeId = type;
    }

    public String getType() {
        return clientTypeId;
    }

}
