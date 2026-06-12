package com.personal.business.deduction.api.routers;

import com.personal.business.deduction.create.routes.CreateDeductionHttpHandler;
import com.personal.business.deduction.delete.routes.DeleteDeductionHttpHandler;
import com.personal.business.deduction.filter.routes.FilterDeductionHttpHandler;
import com.personal.business.deduction.update.routes.UpdateDeductionHttpHandler;

import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;

public class DeductionRouter implements HttpService {

    @Override
    public void routing(HttpRules rules) {
        rules.post("/", new CreateDeductionHttpHandler()::Post);
        rules.put("/", new UpdateDeductionHttpHandler()::Put);
        rules.delete("/{id}", new DeleteDeductionHttpHandler()::Delete);
        rules.post("/filter", new FilterDeductionHttpHandler()::Post);
    }
}
