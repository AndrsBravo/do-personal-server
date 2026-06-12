package com.personal.backoffice.commercial.plan.api.routers;

import com.personal.backoffice.commercial.plan.create.routes.CreateCommercialPlanHttpHandler;
import com.personal.backoffice.commercial.plan.delete.routes.DeleteCommercialPlanHttpHandler;
import com.personal.backoffice.commercial.plan.filter.routes.FilterCommercialPlanHttpHandler;
import com.personal.backoffice.commercial.plan.update.routes.UpdateCommercialPlanHttpHandler;

import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;

public class CommercialPlanRouter implements HttpService {

    @Override
    public void routing(HttpRules rules) {
        rules.post("/", new CreateCommercialPlanHttpHandler()::Post);
        rules.put("/", new UpdateCommercialPlanHttpHandler()::Put);
        rules.delete("/{id}", new DeleteCommercialPlanHttpHandler()::Delete);
        rules.post("/filter", new FilterCommercialPlanHttpHandler()::Post);
    }
}
