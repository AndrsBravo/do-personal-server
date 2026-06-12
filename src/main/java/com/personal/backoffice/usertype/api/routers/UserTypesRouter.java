package com.personal.backoffice.usertype.api.routers;

import com.personal.backoffice.usertype.create.routes.CreateUserTypeHttpHandler;
import com.personal.backoffice.usertype.delete.routes.DeleteUserTypeHttpHandler;
import com.personal.backoffice.usertype.filter.routes.FilterUserTypeHttpHandler;
import com.personal.backoffice.usertype.update.routes.UpdateUserTypeHttpHandler;

import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;

public class UserTypesRouter implements HttpService {

    @Override
    public void routing(HttpRules rules) {
        rules.post("/", new CreateUserTypeHttpHandler()::Post);
        rules.put("/", new UpdateUserTypeHttpHandler()::Put);
        rules.delete("/{id}", new DeleteUserTypeHttpHandler()::Delete);
        rules.post("/filter", new FilterUserTypeHttpHandler()::Post);
    }
}
