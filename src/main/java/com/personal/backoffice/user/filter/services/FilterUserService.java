package com.personal.backoffice.user.filter.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.user.entities.User;
import com.personal.backoffice.user.factories.UserBuilder;
import com.personal.backoffice.user.factories.UserResultFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IFilterService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class FilterUserService implements IFilterService<User> {

    private final Optional<DbClient> dbClient;

    public FilterUserService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<List<User>> filter(Query query) {

        if (dbClient.isEmpty()) {
            return ServicesResultFactory.<List<User>>DbNotAvailable();
        }

        var userQuery = query.Select("users", "id", "us_email", "user_types_id", "user_name", "us_name", "us_last_name")
                .Get();

        //System.out.println(userQuery);
        var result = this.dbClient.get().execute()
                .createQuery(userQuery)
                .params(query.getParams())
                .execute()
                .map(
                        (dbRow) -> UserBuilder.builder().withId(dbRow.column("id").getString())
                                .withEmail(dbRow.column("us_email").getString())
                                .withUserName(dbRow.column("user_name").getString())
                                .withNames(dbRow.column("us_name").getString())
                                .withLastNames(dbRow.column("us_last_name").getString())
                                .build()
                )
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return UserResultFactory.FetchEmpty(query.getKeyPair());
        }

        return UserResultFactory.FetchResult(result);
    }
}
