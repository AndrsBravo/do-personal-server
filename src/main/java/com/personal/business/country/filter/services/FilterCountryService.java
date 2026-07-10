package com.personal.business.country.filter.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.country.entities.Country;
import com.personal.backoffice.user.entities.User;
import com.personal.business.country.factories.CountryResultFactory;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.IFilterService;
import com.personal.shared.services.entities.ServiceResult;

import io.helidon.dbclient.DbClient;

public class FilterCountryService implements IFilterService<Country> {

    private final Optional<DbClient> dbClient;

    public FilterCountryService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<List<Country>> filter(Query query) {

        if (dbClient.isEmpty()) {
            return CountryResultFactory.FetchNull();
        }

        var queryString = query.Select("countries",
                "id", "co_code", "co_name", "co_updated_at", "co_created_at", "co_created_by")
                .Get();

        //System.out.println(queryString);
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

        if (result.isEmpty()) {
            return CountryResultFactory.FetchNull();
        }

        return CountryResultFactory.FetchResult(result);
    }
}
