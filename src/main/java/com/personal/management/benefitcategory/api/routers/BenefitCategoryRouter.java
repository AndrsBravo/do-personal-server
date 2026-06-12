package com.personal.management.benefitcategory.api.routers;

import com.personal.management.benefitcategory.create.routes.CreateBenefitCategoryHttpHandler;
import com.personal.management.benefitcategory.delete.routes.DeleteBenefitCategoryHttpHandler;
import com.personal.management.benefitcategory.filter.routes.FilterBenefitCategoryHttpHandler;
import com.personal.management.benefitcategory.update.routes.UpdateBenefitCategoryHttpHandler;

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
