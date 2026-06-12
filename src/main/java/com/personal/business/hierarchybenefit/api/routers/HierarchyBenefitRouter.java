package com.personal.business.hierarchybenefit.api.routers;

import com.personal.business.hierarchybenefit.create.routes.CreateHierarchyBenefitHttpHandler;
import com.personal.business.hierarchybenefit.delete.routes.DeleteHierarchyBenefitHttpHandler;
import com.personal.business.hierarchybenefit.filter.routes.FilterHierarchyBenefitHttpHandler;
import com.personal.business.hierarchybenefit.update.routes.UpdateHierarchyBenefitHttpHandler;

import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;

public class HierarchyBenefitRouter implements HttpService {

    @Override
    public void routing(HttpRules rules) {
        rules.post("/", new CreateHierarchyBenefitHttpHandler()::Post);
        rules.put("/", new UpdateHierarchyBenefitHttpHandler()::Put);
        rules.delete("/{id}", new DeleteHierarchyBenefitHttpHandler()::Delete);
        rules.post("/filter", new FilterHierarchyBenefitHttpHandler()::Post);
    }
}
