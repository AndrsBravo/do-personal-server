package com.personal.business.country.factories;

import com.personal.business.country.filter.services.FilterCountryService;
import com.personal.business.country.notifications.CountryNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class CountryServiceFactory {

    private static final String TABLE_NAME = "countries";

    public static CreateService CreateCountry() {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(CountryNotificationFactory.CreateCountrySuccess())
                .withFailureNotification(CountryNotificationFactory.CreateCountryFail())
                .build();
    }

    public static FilterCountryService FilterCountries() {

        return new FilterCountryService(DbClientMSSQLFactory.Management());
    }

    public static UpdateService EditCountry() {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(CountryNotificationFactory.UpdateCountrySuccess())
                .withFailureNotification(CountryNotificationFactory.UpdateCountryFail())
                .build();
    }

    public static DeleteService DeleteCountry() {
        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(CountryNotificationFactory.DeleteCountrySuccess())
                .withFailureNotification(CountryNotificationFactory.DeleteCountryFail())
                .build();
    }

}
