package com.personal.management.orgstructure.api.routers;

import com.personal.management.orgstructure.create.routes.CreateOrgStructureHttpHandler;
import com.personal.management.orgstructure.delete.routes.DeleteOrgStructureHttpHandler;
import com.personal.management.orgstructure.filter.routes.FilterOrgStructureHttpHandler;
import com.personal.management.orgstructure.update.routes.UpdateOrgStructureHttpHandler;

import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;

public class OrgStructureRouter implements HttpService {

    @Override
    public void routing(HttpRules rules) {
        rules.post("/", new CreateOrgStructureHttpHandler()::Post);
        rules.put("/", new UpdateOrgStructureHttpHandler()::Put);
        rules.delete("/{id}", new DeleteOrgStructureHttpHandler()::Delete);
        rules.post("/filter", new FilterOrgStructureHttpHandler()::Post);
    }
}
