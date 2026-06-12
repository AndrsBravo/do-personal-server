package com.personal.backoffice.user.associateclient.filter.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.client.entities.Client;
import com.personal.backoffice.user.associateclient.entities.AssociateUserClient;
import com.personal.backoffice.user.entities.User;
import com.personal.backoffice.user.entities.UserRelation;
import com.personal.backoffice.user.entities.UserRole;
import com.personal.backoffice.user.factories.UserResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IFilterService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class FilterAssociatedUserClientService implements IFilterService<AssociateUserClient> {

    private final Optional<DbClient> dbClient;

    public FilterAssociatedUserClientService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<List<AssociateUserClient>> filter(Query query) {

        if (dbClient.isEmpty()) {
            return UserResultFactory.FetchAssociatedUserClientFail();
        }

        var queryString = query.Select("user_has_clients",
                "id", "client_id", "users_id", "user_role_id", "user_relation_id", "updated_at", "created_at", "created_by")
                .Get();

        //System.out.println(queryString);
        var result = this.dbClient.get().execute()
                .createQuery(queryString)
                .params(query.getParams())
                .execute()
                .map((dbRow) -> {
                    var u = new AssociateUserClient();
                    u.setId(dbRow.column("id").getString());
                    u.setClient(new Client(dbRow.column("client_id").getString()));
                    u.setUser(new User(dbRow.column("users_id").getString()));
                    u.setUserRole(new UserRole(dbRow.column("user_role_id").getString()));
                    u.setUserRelation(new UserRelation(dbRow.column("user_relation_id").getString()));
                    u.setCreatedAt(dbRow.column("created_at").get(LocalDateTime.class));
                    u.setUpdatedAt(dbRow.column("updated_at").get(LocalDateTime.class));
                    u.setCreatedBy(new User(dbRow.column("created_by").getString()));
                    return u;
                })
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return UserResultFactory.FetchAssociatedUserClientFail();
        }

        return UserResultFactory.FetchAssociatedUserClientSuccess(result);
    }
}
