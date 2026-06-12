package com.personal.backoffice.client.filter.process;

import com.personal.backoffice.client.entities.Client;
import com.personal.backoffice.client.filter.inputs.FilterClientInput;
import com.personal.backoffice.client.filter.process.rules.FilterClientRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterClientProcessExecutor extends FunctionalProcessExecutor<FilterClientProcess, FilterClientInput, Client> {

    public FilterClientProcessExecutor() {
        super(new FilterClientProcess(), FilterClientRule::new);
    }

    public static FilterClientProcessExecutor builder() {
        return new FilterClientProcessExecutor();
    }

}
