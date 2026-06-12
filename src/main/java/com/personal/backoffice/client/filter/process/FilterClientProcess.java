package com.personal.backoffice.client.filter.process;

import com.personal.backoffice.client.entities.Client;
import com.personal.backoffice.client.filter.inputs.FilterClientInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterClientProcess extends FunctionalProcess<FilterClientInput, Client> {

    public FilterClientProcess() {
        super("filter_clients");
    }

}
