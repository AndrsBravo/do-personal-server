package com.personal.backoffice.user.associatebusiness.filter.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.business.entities.Business;
import com.personal.backoffice.user.associatebusiness.entities.AssociateUserBusiness;
import com.personal.backoffice.user.entities.User;
import com.personal.backoffice.user.entities.UserRelation;
import com.personal.backoffice.user.entities.UserRole;
import com.personal.backoffice.user.factories.UserResultFactory;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.IFilterService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class FilterAssociatedUserBusinessService implements IFilterService<AssociateUserBusiness> {

    private final Optional<DbClient> dbClient;

    public FilterAssociatedUserBusinessService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<List<AssociateUserBusiness>> filter(Query query) {

        if (dbClient.isEmpty()) {
            return UserResultFactory.FetchAssociatedUserBusinessFail();
        }

        var queryString = query.Select("user_has_business",
                "id", "business_id", "users_id", "user_role_id", "user_relation_id", "updated_at", "created_at", "created_by")
                .Get();

        //System.out.println(queryString);
        var result = this.dbClient.get().execute()
                .createQuery(queryString)
                .params(query.getParams())
                .execute()
                .map((dbRow) -> EntityBuilder.Of(AssociateUserBusiness::new)
                .With(AssociateUserBusiness::setId, dbRow.column("id").getString())
                .With(AssociateUserBusiness::setBusiness, new Business(dbRow.column("business_id").getString()))
                .With(AssociateUserBusiness::setUser, new User(dbRow.column("users_id").getString()))
                .With(AssociateUserBusiness::setUserRole, new UserRole(dbRow.column("user_role_id").getString()))
                .With(AssociateUserBusiness::setUserRelation, new UserRelation(dbRow.column("user_relation_id").getString()))
                .With(AssociateUserBusiness::setCreatedAt, dbRow.column("created_at").get(LocalDateTime.class))
                .With(AssociateUserBusiness::setUpdatedAt, dbRow.column("updated_at").get(LocalDateTime.class))
                .With(AssociateUserBusiness::setCreatedBy, new User(dbRow.column("created_by").getString()))
                .Get()
                )
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return UserResultFactory.FetchAssociatedUserBusinessFail();
        }

        return UserResultFactory.FetchAssociatedUserBusinessSuccess(result);
    }
}
