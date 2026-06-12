package com.personal.business.orghierarchy.api.routers;

import com.personal.business.orghierarchy.create.routes.CreateOrgHierarchyHttpHandler;
import com.personal.business.orghierarchy.delete.routes.DeleteOrgHierarchyHttpHandler;
import com.personal.business.orghierarchy.filter.routes.FilterOrgHierarchyHttpHandler;
import com.personal.business.orghierarchy.update.routes.UpdateOrgHierarchyHttpHandler;

import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;

public class OrgHierarchyRouter implements HttpService {

    @Override
    public void routing(HttpRules rules) {
        rules.post("/", new CreateOrgHierarchyHttpHandler()::Post);
        rules.put("/", new UpdateOrgHierarchyHttpHandler()::Put);
        rules.delete("/{id}", new DeleteOrgHierarchyHttpHandler()::Delete);
        rules.post("/filter", new FilterOrgHierarchyHttpHandler()::Post);
    }
}
