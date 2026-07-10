package com.personal.backoffice.country.factories;

import java.util.List;

import com.personal.backoffice.country.entities.Country;
import com.personal.backoffice.country.notifications.CountryNotificationFactory;
import com.personal.shared.services.entities.ServiceResult;

public class CountryResultFactory {

    public static ServiceResult<Country> CreateFail(String message) {
        return new ServiceResult<>(CountryNotificationFactory.CreateCountryFail(message), null);
    }

    public static ServiceResult<Country> CreateSuccess(Country country) {
        return new ServiceResult<>(null, country);
    }

    public static ServiceResult<Country> UpdateFail(String message) {
        return new ServiceResult<>(CountryNotificationFactory.UpdateCountryFail(message), null);
    }

    public static ServiceResult<Country> UpdateSuccess(Country country) {
        return new ServiceResult<>(null, country);
    }

    public static ServiceResult<Country> DeleteSuccess(Country country) {
        return new ServiceResult<>(null, country);
    }

    public static ServiceResult<Country> DeleteFail(String message) {
        return new ServiceResult<>(CountryNotificationFactory.DeleteCountryFail(message), null);
    }

    public static ServiceResult<List<Country>> FetchNull(String message) {
        return new ServiceResult<>(CountryNotificationFactory.FetchNull(message), null);
    }

    public static ServiceResult<List<Country>> FetchResult(List<Country> countries) {
        return new ServiceResult<>(null, countries);
    }

}
