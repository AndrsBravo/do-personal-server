package com.personal.business.orgstructure.api.routers;

import com.personal.business.orgstructure.create.routes.CreateOrgStructureHttpHandler;
import com.personal.business.orgstructure.delete.routes.DeleteOrgStructureHttpHandler;
import com.personal.business.orgstructure.filter.routes.FilterOrgStructureHttpHandler;
import com.personal.business.orgstructure.update.routes.UpdateOrgStructureHttpHandler;

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
