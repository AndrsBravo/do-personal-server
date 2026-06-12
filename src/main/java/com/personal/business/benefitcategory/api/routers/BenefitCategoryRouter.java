package com.personal.business.benefitcategory.api.routers;

import com.personal.business.benefitcategory.create.routes.CreateBenefitCategoryHttpHandler;
import com.personal.business.benefitcategory.delete.routes.DeleteBenefitCategoryHttpHandler;
import com.personal.business.benefitcategory.filter.routes.FilterBenefitCategoryHttpHandler;
import com.personal.business.benefitcategory.update.routes.UpdateBenefitCategoryHttpHandler;

import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;

public class BenefitCategoryRouter implements HttpService {

    @Override
    public void routing(HttpRules rules) {
        rules.post("/", new CreateBenefitCategoryHttpHandler()::Post);
        rules.put("/", new UpdateBenefitCategoryHttpHandler()::Put);
        rules.delete("/{id}", new DeleteBenefitCategoryHttpHandler()::Delete);
        rules.post("/filter", new FilterBenefitCategoryHttpHandler()::Post);
    }
}
