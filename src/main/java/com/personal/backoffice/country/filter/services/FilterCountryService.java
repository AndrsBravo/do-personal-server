package com.personal.backoffice.country.filter.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.country.entities.Country;
import com.personal.backoffice.country.factories.CountryResultFactory;
import com.personal.backoffice.user.entities.User;
import com.personal.shared.query.Query;
import com.personal.shared.services.IFilterService;
import com.personal.shared.services.ServiceResult;

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
                "id", "oc_code", "oc_name", "oc_updated_at", "oc_created_at", "oc_created_by")
                .Get();

        //System.out.println(queryString);
        var result = this.dbClient.get().execute()
                .createQuery(queryString)
                .params(query.getParams())
                .execute()
                .map((dbRow) -> {
                    var u = new Country();
                    u.setId(dbRow.column("id").getString());
                    u.setCode(dbRow.column("oc_code").getString());
                    u.setName(dbRow.column("oc_name").getString());
                    u.setCreatedAt(dbRow.column("oc_created_at").get(LocalDateTime.class));
                    u.setUpdatedAt(dbRow.column("oc_updated_at").get(LocalDateTime.class));
                    u.setCreatedBy(new User(dbRow.column("oc_created_by").getString()));
                    return u;
                })
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return CountryResultFactory.FetchNull();
        }

        return CountryResultFactory.FetchResult(result);
    }
}
