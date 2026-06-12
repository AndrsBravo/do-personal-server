package com.personal.business.orgrelation.api.routers;

import com.personal.business.orgrelation.create.routes.CreateOrgRelationHttpHandler;
import com.personal.business.orgrelation.delete.routes.DeleteOrgRelationHttpHandler;
import com.personal.business.orgrelation.filter.routes.FilterOrgRelationHttpHandler;
import com.personal.business.orgrelation.update.routes.UpdateOrgRelationHttpHandler;

import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;

public class OrgRelationRouter implements HttpService {

    @Override
    public void routing(HttpRules rules) {
        rules.post("/", new CreateOrgRelationHttpHandler()::Post);
        rules.put("/", new UpdateOrgRelationHttpHandler()::Put);
        rules.delete("/{id}", new DeleteOrgRelationHttpHandler()::Delete);
        rules.post("/filter", new FilterOrgRelationHttpHandler()::Post);
    }
}
