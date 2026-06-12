package com.personal.business.country.factories;

import com.personal.business.country.create.services.CreateCountryService;
import com.personal.business.country.delete.services.DeleteCountryService;
import com.personal.business.country.filter.services.FilterCountryService;
import com.personal.business.country.update.services.EditCountryService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class CountryServiceFactory {

    public static CreateCountryService CreateCountry() {

        return new CreateCountryService(DbClientMSSQLFactory.Management());
    }

    public static FilterCountryService FilterCountries() {

        return new FilterCountryService(DbClientMSSQLFactory.Management());
    }

    public static EditCountryService EditCountry() {

        return new EditCountryService(DbClientMSSQLFactory.Management());
    }

    public static DeleteCountryService DeleteCountry() {

        return new DeleteCountryService(DbClientMSSQLFactory.Management());
    }

}
