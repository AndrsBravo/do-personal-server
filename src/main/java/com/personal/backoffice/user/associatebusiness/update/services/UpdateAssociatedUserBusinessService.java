package com.personal.backoffice.user.associatebusiness.update.services;

import java.util.Optional;

import com.personal.backoffice.user.associatebusiness.entities.AssociateUserBusiness;
import com.personal.backoffice.user.factories.UserResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class UpdateAssociatedUserBusinessService implements IEditService<AssociateUserBusiness> {

    private final Optional<DbClient> dbClient;

    public UpdateAssociatedUserBusinessService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<AssociateUserBusiness> edit(Query query) {

        if (dbClient.isEmpty()) {
            return UserResultFactory.UpdateAssociatedUserBusinessFail();
        }

        var dbclient = dbClient.get();

        var userQuery = query.Update("user_has_business").Get();
        //System.out.println(userQuery);

        var userResult = dbclient.execute()
                .createUpdate(userQuery)
                .params(query.getParams())
                .execute();

        //System.out.println("userResult " + userResult);
        if (userResult == 0) {
            return UserResultFactory.UpdateAssociatedUserBusinessFail();
        }
        return UserResultFactory.UpdateAssociatedUserBusinessSuccess(new AssociateUserBusiness(query.getParams().get("id")));

    }
}
