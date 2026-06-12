package com.personal.backoffice.country.factories;

import com.personal.backoffice.country.create.services.CreateCountryService;
import com.personal.backoffice.country.delete.services.DeleteCountryService;
import com.personal.backoffice.country.filter.services.FilterCountryService;
import com.personal.backoffice.country.update.services.EditCountryService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class CountryServiceFactory {

    public static CreateCountryService CreateCountry() {

        return new CreateCountryService(DbClientMSSQLFactory.SystemMaster());
    }

    public static FilterCountryService FilterCountries() {

        return new FilterCountryService(DbClientMSSQLFactory.SystemMaster());
    }

    public static EditCountryService EditCountry() {

        return new EditCountryService(DbClientMSSQLFactory.SystemMaster());
    }

    public static DeleteCountryService DeleteCountry() {

        return new DeleteCountryService(DbClientMSSQLFactory.SystemMaster());
    }

}
