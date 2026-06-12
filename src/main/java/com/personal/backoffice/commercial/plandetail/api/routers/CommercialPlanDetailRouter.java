package com.personal.backoffice.commercial.plandetail.api.routers;

import com.personal.backoffice.commercial.plandetail.create.routes.CreateCommercialPlanDetailHttpHandler;
import com.personal.backoffice.commercial.plandetail.delete.routes.DeleteCommercialPlanDetailHttpHandler;
import com.personal.backoffice.commercial.plandetail.filter.routes.FilterCommercialPlanDetailHttpHandler;
import com.personal.backoffice.commercial.plandetail.update.routes.UpdateCommercialPlanDetailHttpHandler;

import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;

public class CommercialPlanDetailRouter implements HttpService {

    @Override
    public void routing(HttpRules rules) {
        rules.post("/", new CreateCommercialPlanDetailHttpHandler()::Post);
        rules.put("/", new UpdateCommercialPlanDetailHttpHandler()::Put);
        rules.delete("/{id}", new DeleteCommercialPlanDetailHttpHandler()::Delete);
        rules.post("/filter", new FilterCommercialPlanDetailHttpHandler()::Post);
    }
}
