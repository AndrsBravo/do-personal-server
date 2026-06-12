package com.personal.business.hierarchydeduction.api.routers;

import com.personal.business.hierarchydeduction.create.routes.CreateHierarchyDeductionHttpHandler;
import com.personal.business.hierarchydeduction.delete.routes.DeleteHierarchyDeductionHttpHandler;
import com.personal.business.hierarchydeduction.filter.routes.FilterHierarchyDeductionHttpHandler;
import com.personal.business.hierarchydeduction.update.routes.UpdateHierarchyDeductionHttpHandler;

import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;

public class HierarchyDeductionRouter implements HttpService {

    @Override
    public void routing(HttpRules rules) {
        rules.post("/", new CreateHierarchyDeductionHttpHandler()::Post);
        rules.put("/", new UpdateHierarchyDeductionHttpHandler()::Put);
        rules.delete("/{id}", new DeleteHierarchyDeductionHttpHandler()::Delete);
        rules.post("/filter", new FilterHierarchyDeductionHttpHandler()::Post);
    }
}
