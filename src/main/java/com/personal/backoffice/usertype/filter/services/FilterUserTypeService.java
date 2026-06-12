package com.personal.backoffice.usertype.filter.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.user.entities.User;
import com.personal.backoffice.usertype.factories.UserTypeResultFactory;
import com.personal.shared.entities.TypeEntityBase;
import com.personal.shared.query.Query;
import com.personal.shared.services.IFilterService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class FilterUserTypeService implements IFilterService<TypeEntityBase> {

    private final Optional<DbClient> dbClient;

    public FilterUserTypeService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<List<TypeEntityBase>> filter(Query query) {

        if (dbClient.isEmpty()) {
            return UserTypeResultFactory.FetchNull();
        }

        var queryString = query.Select("user_types",
                "id", "ust_type", "ust_description", "ust_updated_at", "ust_created_at", "ust_created_by")
                .Get();

        //System.out.println(queryString);
        var result = this.dbClient.get().execute()
                .createQuery(queryString)
                .params(query.getParams())
                .execute()
                .map((dbRow) -> {
                    var u = new TypeEntityBase();
                    u.setId(dbRow.column("id").getString());
                    u.setType(dbRow.column("ust_type").getString());
                    u.setDescription(dbRow.column("ust_description").getString());
                    u.setCreatedAt(dbRow.column("ust_created_at").get(LocalDateTime.class));
                    u.setUpdatedAt(dbRow.column("ust_updated_at").get(LocalDateTime.class));
                    u.setCreatedBy(new User(dbRow.column("ust_created_by").getString()));
                    return u;
                })
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return UserTypeResultFactory.FetchNull();
        }

        return UserTypeResultFactory.FetchResult(result);
    }
}
