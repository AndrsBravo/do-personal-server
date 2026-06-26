package com.personal.backoffice.userrole.filter.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.user.entities.User;
import com.personal.backoffice.userrole.entities.UserRole;
import com.personal.backoffice.userrole.factories.UserRoleResultFactory;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.IFilterService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class FilterUserRoleService implements IFilterService<UserRole> {

    private final Optional<DbClient> dbClient;

    public FilterUserRoleService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<List<UserRole>> filter(Query query) {

        if (dbClient.isEmpty()) {
            return UserRoleResultFactory.FetchNull();
        }

        var queryString = query.Select("user_role",
                "id", "url_updated_at", "url_created_at", "url_created_by")
                .Get();

        //System.out.println(queryString);
        var result = this.dbClient.get().execute()
                .createQuery(queryString)
                .params(query.getParams())
                .execute()
                .map((dbRow) -> EntityBuilder.Of(UserRole::new)
                .With(UserRole::setId, dbRow.column("id").getString())
                .With(UserRole::setCreatedAt, dbRow.column("url_created_at").get(LocalDateTime.class))
                .With(UserRole::setUpdatedAt, dbRow.column("url_updated_at").get(LocalDateTime.class))
                .With(UserRole::setCreatedBy, new User(dbRow.column("url_created_by").getString()))
                .Get()
                )
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return UserRoleResultFactory.FetchNull();
        }

        return UserRoleResultFactory.FetchResult(result);
    }
}
