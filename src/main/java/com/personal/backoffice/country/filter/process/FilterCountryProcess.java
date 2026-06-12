package com.personal.backoffice.country.filter.process;

import com.personal.backoffice.country.entities.Country;
import com.personal.backoffice.country.filter.inputs.FilterCountryInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterCountryProcess extends FunctionalProcess<FilterCountryInput, Country> {

    public FilterCountryProcess() {
        super("filter_countries");
    }

}
