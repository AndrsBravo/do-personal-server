package com.personal.management.benefitrate.api.routers;

import com.personal.management.benefitrate.create.routes.CreateBenefitRateHttpHandler;
import com.personal.management.benefitrate.delete.routes.DeleteBenefitRateHttpHandler;
import com.personal.management.benefitrate.filter.routes.FilterBenefitRateHttpHandler;
import com.personal.management.benefitrate.update.routes.UpdateBenefitRateHttpHandler;

import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;

public class BenefitRateRouter implements HttpService {

    @Override
    public void routing(HttpRules rules) {
        rules.post("/", new CreateBenefitRateHttpHandler()::Post);
        rules.put("/", new UpdateBenefitRateHttpHandler()::Put);
        rules.delete("/{id}", new DeleteBenefitRateHttpHandler()::Delete);
        rules.post("/filter", new FilterBenefitRateHttpHandler()::Post);
    }
}
