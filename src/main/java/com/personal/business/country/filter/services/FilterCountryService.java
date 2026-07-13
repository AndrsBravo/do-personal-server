package com.personal.business.country.filter.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.country.entities.Country;
import com.personal.backoffice.user.entities.User;
import com.personal.business.country.notifications.CountryNotificationFactory;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.FilterService;
import com.personal.shared.services.entities.FetchResult;

import io.helidon.dbclient.DbClient;

public class FilterCountryService extends FilterService<Country> {

    public FilterCountryService(Optional<DbClient> dbClient) {
        super(dbClient);
    }

    @Override
    public FetchResult<Country> filter(Query query) {

        if (dbClient.isEmpty()) {
            return builder.NotAvailable();
        }

        var queryString = query.Select("countries",
                "id", "co_code", "co_name", "co_updated_at", "co_created_at", "co_created_by")
                .Get();

        try {
            var result = this.dbClient.get().execute()
                    .createQuery(queryString)
                    .params(query.getParams())
                    .execute()
                    .map((dbRow) -> EntityBuilder.Of(Country::new)
                    .With(Country::setId, dbRow.column("id").getString())
                    .With(Country::setCode, dbRow.column("co_code").getString())
                    .With(Country::setName, dbRow.column("co_name").getString())
                    .With(Country::setCreatedAt, dbRow.column("co_created_at").get(LocalDateTime.class))
                    .With(Country::setUpdatedAt, dbRow.column("co_updated_at").get(LocalDateTime.class))
                    .With(Country::setCreatedBy, new User(dbRow.column("co_created_by").getString()))
                    .Get()
                    )
                    .collect(Collectors.toList());

            builder.withResult(result)
                    .withNotification(CountryNotificationFactory.FetchCountrySuccess());
        } catch (Exception e) {
            builder.withException(e).
                    withNotification(CountryNotificationFactory.FetchCountryFail());
        }

        return builder.get();
    }
}
