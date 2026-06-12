package com.personal.backoffice.country.filter.process.rules;

import com.personal.backoffice.country.factories.CountryServiceFactory;
import com.personal.backoffice.country.filter.process.FilterCountryProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterCountryRule implements IProcessRule<FilterCountryProcess> {

    @Override
    public void apply(FilterCountryProcess process) {

        var pLogger = LogFactory.builder(FilterCountryProcess.class, FilterCountryRule.class);
        var query = process.Query();
        var initObject = process.getInitObject();

        if (initObject.getAll() != null) {
            query.Field("id", "");
            query.Where().AndNotEmpty("id");
        }

        if (initObject.getId() != null) {
            query.Field("id", initObject.getId());
            query.Where().AndEqu("id");
        }

        if (initObject.getCode() != null) {
            query.Field("oc_code", initObject.getCode());
            query.Where().AndEqu("oc_code");
        }

        if (initObject.getName() != null) {
            query.Field("oc_name", initObject.getName());
            query.Where().AndEqu("oc_name");
        }

        var filterCountry = CountryServiceFactory.FilterCountries();

        var result = filterCountry.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Types", "Filtered user types with properties: " + query.getKeyPair()));
    }

}
