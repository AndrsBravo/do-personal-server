package com.personal.management.country.filter.process.rules;

import com.personal.management.country.factories.CountryServiceFactory;
import com.personal.management.country.filter.process.FilterCountryProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterCountryRule implements IProcessRule<FilterCountryProcess> {

    @Override
    public void apply(FilterCountryProcess process) {

        var pLogger = LogFactory.builder(FilterCountryProcess.class, FilterCountryRule.class);
        var query = process.Query();

        var countryFilter = process.getInitObject();

        if (countryFilter.getId() != null) {
            query.Field("id", countryFilter.getId());
            query.Where().Field("id", countryFilter.getId());
        }

        if (countryFilter.getCode() != null) {
            query.Field("co_code", countryFilter.getCode());
            query.Where().AndEqu("co_code");
        }

        if (countryFilter.getName() != null) {
            query.Field("co_name", countryFilter.getName());
            query.Where().AndEqu("co_name");
        }

        var filterCountry = CountryServiceFactory.FilterCountries();

        var result = filterCountry.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Types", "Filtered user types with properties: " + query.getKeyPair()));
    }

}
