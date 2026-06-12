package com.personal.backoffice.business.process.filter;

import com.personal.backoffice.business.api.inputs.FilterBusinessInput;
import com.personal.backoffice.business.entities.Business;
import com.personal.backoffice.business.process.filter.rules.FilterBusinessRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterBusinessProcessExecutor extends FunctionalProcessExecutor<FilterBusinessProcess, FilterBusinessInput, Business> {

    public FilterBusinessProcessExecutor() {
        super(new FilterBusinessProcess(), FilterBusinessRule::new);
    }

    public static FilterBusinessProcessExecutor builder() {
        return new FilterBusinessProcessExecutor();
    }

}
