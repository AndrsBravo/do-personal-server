package com.personal.business.hierarchy.api.routers;

import com.personal.business.hierarchy.create.routes.CreateHierarchyHttpHandler;
import com.personal.business.hierarchy.delete.routes.DeleteHierarchyHttpHandler;
import com.personal.business.hierarchy.filter.routes.FilterHierarchyHttpHandler;
import com.personal.business.hierarchy.update.routes.UpdateHierarchyHttpHandler;

import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;

public class HierarchyRouter implements HttpService {

    @Override
    public void routing(HttpRules rules) {
        rules.post("/", new CreateHierarchyHttpHandler()::Post);
        rules.put("/", new UpdateHierarchyHttpHandler()::Put);
        rules.delete("/{id}", new DeleteHierarchyHttpHandler()::Delete);
        rules.post("/filter", new FilterHierarchyHttpHandler()::Post);
    }
}
