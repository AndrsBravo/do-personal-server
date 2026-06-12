package com.personal.management.country.factories;

import com.personal.management.country.create.services.CreateCountryService;
import com.personal.management.country.delete.services.DeleteCountryService;
import com.personal.management.country.filter.services.FilterCountryService;
import com.personal.management.country.update.services.EditCountryService;
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
