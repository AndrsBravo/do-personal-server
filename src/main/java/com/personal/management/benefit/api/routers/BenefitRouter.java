package com.personal.management.benefit.api.routers;

import com.personal.management.benefit.create.routes.CreateBenefitHttpHandler;
import com.personal.management.benefit.delete.routes.DeleteBenefitHttpHandler;
import com.personal.management.benefit.filter.routes.FilterBenefitHttpHandler;
import com.personal.management.benefit.update.routes.UpdateBenefitHttpHandler;

import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;

public class BenefitRouter implements HttpService {

    @Override
    public void routing(HttpRules rules) {
        rules.post("/", new CreateBenefitHttpHandler()::Post);
        rules.put("/", new UpdateBenefitHttpHandler()::Put);
        rules.delete("/{id}", new DeleteBenefitHttpHandler()::Delete);
        rules.post("/filter", new FilterBenefitHttpHandler()::Post);
    }
}
