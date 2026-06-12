package com.personal.backoffice.user.associateclient.update.services;

import java.util.Optional;

import com.personal.backoffice.user.associateclient.entities.AssociateUserClient;
import com.personal.backoffice.user.factories.UserResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class UpdateAssociatedUserClientService implements IEditService<AssociateUserClient> {

    private final Optional<DbClient> dbClient;

    public UpdateAssociatedUserClientService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<AssociateUserClient> edit(Query query) {

        if (dbClient.isEmpty()) {
            return UserResultFactory.UpdateAssociatedUserClientFail();
        }

        var dbclient = dbClient.get();

        var userQuery = query.Update("user_has_clients").Get();
        //System.out.println(userQuery);

        var userResult = dbclient.execute()
                .createUpdate(userQuery)
                .params(query.getParams())
                .execute();

        //System.out.println("userResult " + userResult);
        if (userResult == 0) {
            return UserResultFactory.UpdateAssociatedUserClientFail();
        }
        return UserResultFactory.UpdateAssociatedUserClientSuccess(new AssociateUserClient(query.getParams().get("id")));

    }
}
