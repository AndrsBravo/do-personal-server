package com.personal.business.benefit.api.routers;

import com.personal.business.benefit.create.routes.CreateBenefitHttpHandler;
import com.personal.business.benefit.delete.routes.DeleteBenefitHttpHandler;
import com.personal.business.benefit.filter.routes.FilterBenefitHttpHandler;
import com.personal.business.benefit.update.routes.UpdateBenefitHttpHandler;

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
