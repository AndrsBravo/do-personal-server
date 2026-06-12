package com.personal.business.benefitrate.api.routers;

import com.personal.business.benefitrate.create.routes.CreateBenefitRateHttpHandler;
import com.personal.business.benefitrate.delete.routes.DeleteBenefitRateHttpHandler;
import com.personal.business.benefitrate.filter.routes.FilterBenefitRateHttpHandler;
import com.personal.business.benefitrate.update.routes.UpdateBenefitRateHttpHandler;

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
