package com.personal.management.deduction.api.routers;

import com.personal.management.deduction.create.routes.CreateDeductionHttpHandler;
import com.personal.management.deduction.delete.routes.DeleteDeductionHttpHandler;
import com.personal.management.deduction.filter.routes.FilterDeductionHttpHandler;
import com.personal.management.deduction.update.routes.UpdateDeductionHttpHandler;

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
