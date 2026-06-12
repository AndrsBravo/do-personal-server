package com.personal.backoffice.business.process.filter;

import com.personal.backoffice.business.api.inputs.FilterBusinessInput;
import com.personal.backoffice.business.entities.Business;
import com.personal.shared.process.FunctionalProcess;

public class FilterBusinessProcess extends FunctionalProcess<FilterBusinessInput, Business> {

    public FilterBusinessProcess() {
        super("filter_business");
    }

}
