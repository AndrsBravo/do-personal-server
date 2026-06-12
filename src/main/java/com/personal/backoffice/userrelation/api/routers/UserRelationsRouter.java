package com.personal.backoffice.userrelation.api.routers;

import com.personal.backoffice.userrelation.create.routes.CreateUserRelationHttpHandler;
import com.personal.backoffice.userrelation.delete.routes.DeleteUserRelationHttpHandler;
import com.personal.backoffice.userrelation.filter.routes.FilterUserRelationHttpHandler;
import com.personal.backoffice.userrelation.update.routes.UpdateUserRelationHttpHandler;

import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;

public class UserRelationsRouter implements HttpService {

    @Override
    public void routing(HttpRules rules) {
        rules.post("/", new CreateUserRelationHttpHandler()::Post);
        rules.put("/", new UpdateUserRelationHttpHandler()::Put);
        rules.delete("/{id}", new DeleteUserRelationHttpHandler()::Delete);
        rules.post("/filter", new FilterUserRelationHttpHandler()::Post);
    }
}
