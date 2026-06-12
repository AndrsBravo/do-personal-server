package com.personal.business.deductionrate.api.routers;

import com.personal.business.deductionrate.create.routes.CreateDeductionRateHttpHandler;
import com.personal.business.deductionrate.delete.routes.DeleteDeductionRateHttpHandler;
import com.personal.business.deductionrate.filter.routes.FilterDeductionRateHttpHandler;
import com.personal.business.deductionrate.update.routes.UpdateDeductionRateHttpHandler;

import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;

public class DeductionRateRouter implements HttpService {

    @Override
    public void routing(HttpRules rules) {
        rules.post("/", new CreateDeductionRateHttpHandler()::Post);
        rules.put("/", new UpdateDeductionRateHttpHandler()::Put);
        rules.delete("/{id}", new DeleteDeductionRateHttpHandler()::Delete);
        rules.post("/filter", new FilterDeductionRateHttpHandler()::Post);
    }
}
