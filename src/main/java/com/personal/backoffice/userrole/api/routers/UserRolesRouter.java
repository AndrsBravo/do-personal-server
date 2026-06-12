package com.personal.backoffice.userrole.api.routers;

import com.personal.backoffice.userrole.create.routes.CreateUserRoleHttpHandler;
import com.personal.backoffice.userrole.delete.routes.DeleteUserRoleHttpHandler;
import com.personal.backoffice.userrole.filter.routes.FilterUserRoleHttpHandler;
import com.personal.backoffice.userrole.update.routes.UpdateUserRoleHttpHandler;

import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;

public class UserRolesRouter implements HttpService {

    @Override
    public void routing(HttpRules rules) {
        rules.post("/", new CreateUserRoleHttpHandler()::Post);
        rules.put("/", new UpdateUserRoleHttpHandler()::Put);
        rules.delete("/{id}", new DeleteUserRoleHttpHandler()::Delete);
        rules.post("/filter", new FilterUserRoleHttpHandler()::Post);
    }
}
