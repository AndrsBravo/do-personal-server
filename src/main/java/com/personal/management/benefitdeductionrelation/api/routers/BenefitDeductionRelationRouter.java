package com.personal.management.benefitdeductionrelation.api.routers;

import com.personal.management.benefitdeductionrelation.create.routes.CreateBenefitDeductionRelationHttpHandler;
import com.personal.management.benefitdeductionrelation.delete.routes.DeleteBenefitDeductionRelationHttpHandler;
import com.personal.management.benefitdeductionrelation.filter.routes.FilterBenefitDeductionRelationHttpHandler;
import com.personal.management.benefitdeductionrelation.update.routes.UpdateBenefitDeductionRelationHttpHandler;

import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;

public class BenefitDeductionRelationRouter implements HttpService {

    @Override
    public void routing(HttpRules rules) {
        rules.post("/", new CreateBenefitDeductionRelationHttpHandler()::Post);
        rules.put("/", new UpdateBenefitDeductionRelationHttpHandler()::Put);
        rules.delete("/{id}", new DeleteBenefitDeductionRelationHttpHandler()::Delete);
        rules.post("/filter", new FilterBenefitDeductionRelationHttpHandler()::Post);
    }
}
