package com.personal.business.user.filter.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.business.user.entities.User;
import com.personal.business.user.factories.UserResultFactory;
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

        var userQuery = query.Select("users", "id")
                .Get();

        //System.out.println(userQuery);
        var result = this.dbClient.get().execute()
                .createQuery(userQuery)
                .params(query.getParams())
                .execute()
                .map(
                        (dbRow) -> new User(dbRow.column("id").getString())
                )
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return UserResultFactory.FetchEmpty(query.getKeyPair());
        }

        return UserResultFactory.FetchResult(result);
    }
}
