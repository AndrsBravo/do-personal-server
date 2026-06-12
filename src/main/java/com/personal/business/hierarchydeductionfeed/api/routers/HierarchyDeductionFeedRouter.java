package com.personal.business.hierarchydeductionfeed.api.routers;

import com.personal.business.hierarchydeductionfeed.create.routes.CreateHierarchyDeductionFeedHttpHandler;
import com.personal.business.hierarchydeductionfeed.delete.routes.DeleteHierarchyDeductionFeedHttpHandler;
import com.personal.business.hierarchydeductionfeed.filter.routes.FilterHierarchyDeductionFeedHttpHandler;
import com.personal.business.hierarchydeductionfeed.update.routes.UpdateHierarchyDeductionFeedHttpHandler;

import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;

public class HierarchyDeductionFeedRouter implements HttpService {

    @Override
    public void routing(HttpRules rules) {
        rules.post("/", new CreateHierarchyDeductionFeedHttpHandler()::Post);
        rules.put("/", new UpdateHierarchyDeductionFeedHttpHandler()::Put);
        rules.delete("/{id}", new DeleteHierarchyDeductionFeedHttpHandler()::Delete);
        rules.post("/filter", new FilterHierarchyDeductionFeedHttpHandler()::Post);
    }
}
