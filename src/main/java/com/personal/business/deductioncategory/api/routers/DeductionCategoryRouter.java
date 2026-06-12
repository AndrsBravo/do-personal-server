package com.personal.business.deductioncategory.api.routers;

import com.personal.business.deductioncategory.create.routes.CreateDeductionCategoryHttpHandler;
import com.personal.business.deductioncategory.delete.routes.DeleteDeductionCategoryHttpHandler;
import com.personal.business.deductioncategory.filter.routes.FilterDeductionCategoryHttpHandler;
import com.personal.business.deductioncategory.update.routes.UpdateDeductionCategoryHttpHandler;

import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;

public class DeductionCategoryRouter implements HttpService {

    @Override
    public void routing(HttpRules rules) {
        rules.post("/", new CreateDeductionCategoryHttpHandler()::Post);
        rules.put("/", new UpdateDeductionCategoryHttpHandler()::Put);
        rules.delete("/{id}", new DeleteDeductionCategoryHttpHandler()::Delete);
        rules.post("/filter", new FilterDeductionCategoryHttpHandler()::Post);
    }
}
