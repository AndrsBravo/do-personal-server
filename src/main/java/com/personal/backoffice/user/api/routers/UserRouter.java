package com.personal.backoffice.user.api.routers;

import com.personal.backoffice.user.associatebusiness.add.routes.AssociateUserBusinessHttpHandler;
import com.personal.backoffice.user.associatebusiness.delete.routes.DeleteAssociatedUserBusinessHttpHandler;
import com.personal.backoffice.user.associatebusiness.filter.routes.FilterAssociatedUserBusinessHttpHandler;
import com.personal.backoffice.user.associatebusiness.update.routes.UpdateAssociatedUserBusinessHttpHandler;
import com.personal.backoffice.user.associateclient.add.routes.AssociateUserClientHttpHandler;
import com.personal.backoffice.user.associateclient.delete.routes.DeleteAssociatedUserClientHttpHandler;
import com.personal.backoffice.user.associateclient.filter.routes.FilterAssociatedUserClientHttpHandler;
import com.personal.backoffice.user.associateclient.update.routes.UpdateAssociatedUserClientHttpHandler;
import com.personal.backoffice.user.create.routes.CreateUserHttpHandler;
import com.personal.backoffice.user.filter.routes.FilterUserHttpHandler;
import com.personal.backoffice.user.update.routes.UpdateUserHttpHandler;

import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;

public class UserRouter implements HttpService {

    @Override
    public void routing(HttpRules rules) {
        rules.post("/", new CreateUserHttpHandler()::Post);
        rules.put("/", new UpdateUserHttpHandler()::Put);
        rules.post("/filter", new FilterUserHttpHandler()::Post);
        rules.post("/associatedclients", new AssociateUserClientHttpHandler()::Post);
        rules.put("/associatedclients", new UpdateAssociatedUserClientHttpHandler()::Put);
        rules.delete("/associatedclients", new DeleteAssociatedUserClientHttpHandler()::Delete);
        rules.post("/associatedclients/filter", new FilterAssociatedUserClientHttpHandler()::Post);
        rules.post("/associatedbusiness", new AssociateUserBusinessHttpHandler()::Post);
        rules.put("/associatedbusiness", new UpdateAssociatedUserBusinessHttpHandler()::Put);
        rules.delete("/associatedbusiness", new DeleteAssociatedUserBusinessHttpHandler()::Delete);
        rules.post("/associatedbusiness/filter", new FilterAssociatedUserBusinessHttpHandler()::Post);
    }

}
