package com.personal.backoffice.business.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.business.entities.Business;
import com.personal.backoffice.business.factories.BusinessResultFactory;
import com.personal.backoffice.client.entities.Client;
import com.personal.backoffice.user.entities.User;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.IFilterService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class FilterBusinessService implements IFilterService<Business> {

    private final Optional<DbClient> dbBusiness;

    public FilterBusinessService(Optional<DbClient> dbBusiness) {
        this.dbBusiness = dbBusiness;
    }

    @Override
    public ServiceResult<List<Business>> filter(Query query) {

        if (dbBusiness.isEmpty()) {
            return BusinessResultFactory.FetchNull();
        }

        var queryString = query.Select("business",
                "id", "client_id", "bss_name", "bss_db_name", "bss_updated_at", "bss_created_at", "bss_created_by")
                .Get();

        //System.out.println(queryString);
        var result = this.dbBusiness.get().execute()
                .createQuery(queryString)
                .params(query.getParams())
                .execute()
                .map((dbRow)
                        -> EntityBuilder.Of(Business::new)
                        .With(Business::setId, dbRow.column("id").getString())
                        .With(Business::setName, dbRow.column("bss_name").getString())
                        .With(Business::setDbName, dbRow.column("bss_db_name").getString())
                        .With(Business::setClient, EntityBuilder.Of(Client::new).With(Client::setId, dbRow.column("client_id").getString()).Get())
                        .With(Business::setCreatedAt, dbRow.column("bss_created_at").get(LocalDateTime.class))
                        .With(Business::setUpdatedAt, dbRow.column("bss_updated_at").get(LocalDateTime.class))
                        .With(Business::setCreatedBy, new User(dbRow.column("bss_created_by").getString()))
                        .Get()
                )
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return BusinessResultFactory.FetchNull();
        }

        return BusinessResultFactory.FetchResult(result);
    }
}
