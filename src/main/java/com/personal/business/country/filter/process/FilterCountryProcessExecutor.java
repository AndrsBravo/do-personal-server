package com.personal.business.country.filter.process;

import com.personal.backoffice.country.entities.Country;
import com.personal.business.country.filter.inputs.FilterCountryInput;
import com.personal.business.country.filter.process.rules.FilterCountryRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterCountryProcessExecutor extends FunctionalProcessExecutor<FilterCountryProcess, FilterCountryInput, Country> {

    public FilterCountryProcessExecutor() {
        super(new FilterCountryProcess(), FilterCountryRule::new);
    }

    public static FilterCountryProcessExecutor builder() {
        return new FilterCountryProcessExecutor();
    }

}
