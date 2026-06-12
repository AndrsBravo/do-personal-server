package com.personal.backoffice.business.api.routers;

import com.personal.backoffice.business.api.routes.CreateBusinessHttpHandler;
import com.personal.backoffice.business.api.routes.DeleteBusinessHttpHandler;
import com.personal.backoffice.business.api.routes.FilterBusinessHttpHandler;
import com.personal.backoffice.business.api.routes.UpdateBusinessHttpHandler;

import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;

public class BusinessRouter implements HttpService {

    @Override
    public void routing(HttpRules rules) {
        rules.post("/", new CreateBusinessHttpHandler()::Post);
        rules.put("/", new UpdateBusinessHttpHandler()::Put);
        rules.delete("/{id}", new DeleteBusinessHttpHandler()::Delete);
        rules.post("/filter", new FilterBusinessHttpHandler()::Post);
    }
}
