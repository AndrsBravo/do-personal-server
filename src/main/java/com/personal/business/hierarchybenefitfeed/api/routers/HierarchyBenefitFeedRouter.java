package com.personal.business.hierarchybenefitfeed.api.routers;

import com.personal.business.hierarchybenefitfeed.create.routes.CreateHierarchyBenefitFeedHttpHandler;
import com.personal.business.hierarchybenefitfeed.delete.routes.DeleteHierarchyBenefitFeedHttpHandler;
import com.personal.business.hierarchybenefitfeed.filter.routes.FilterHierarchyBenefitFeedHttpHandler;
import com.personal.business.hierarchybenefitfeed.update.routes.UpdateHierarchyBenefitFeedHttpHandler;

import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;

public class HierarchyBenefitFeedRouter implements HttpService {

    @Override
    public void routing(HttpRules rules) {
        rules.post("/", new CreateHierarchyBenefitFeedHttpHandler()::Post);
        rules.put("/", new UpdateHierarchyBenefitFeedHttpHandler()::Put);
        rules.delete("/{id}", new DeleteHierarchyBenefitFeedHttpHandler()::Delete);
        rules.post("/filter", new FilterHierarchyBenefitFeedHttpHandler()::Post);
    }
}
