package com.personal.backoffice.country.factories;

import java.util.List;

import com.personal.backoffice.country.entities.Country;
import com.personal.backoffice.country.notifications.CountryNotificationFactory;
import com.personal.shared.services.ServiceResult;

public class CountryResultFactory {

    public static ServiceResult<Country> CreateFail() {
        return new ServiceResult<>(CountryNotificationFactory.CreateCountryFail(), null);
    }

    public static ServiceResult<Country> CreateSuccess(Country country) {
        return new ServiceResult<>(null, country);
    }

    public static ServiceResult<Country> UpdateFail() {
        return new ServiceResult<>(CountryNotificationFactory.UpdateCountryFail(), null);
    }

    public static ServiceResult<Country> UpdateSuccess(Country country) {
        return new ServiceResult<>(null, country);
    }

    public static ServiceResult<Country> DeleteSuccess(Country country) {
        return new ServiceResult<>(null, country);
    }

    public static ServiceResult<Country> DeleteFail() {
        return new ServiceResult<>(CountryNotificationFactory.DeleteCountryFail(), null);
    }

    public static ServiceResult<List<Country>> FetchNull() {
        return new ServiceResult<>(CountryNotificationFactory.FetchNull(), null);
    }

    public static ServiceResult<List<Country>> FetchResult(List<Country> countries) {
        return new ServiceResult<>(null, countries);
    }

}
