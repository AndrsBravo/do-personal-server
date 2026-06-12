package com.personal.business.employeedeductionfeed.api.routers;

import com.personal.business.employeedeductionfeed.create.routes.CreateEmployeeDeductionFeedHttpHandler;
import com.personal.business.employeedeductionfeed.delete.routes.DeleteEmployeeDeductionFeedHttpHandler;
import com.personal.business.employeedeductionfeed.filter.routes.FilterEmployeeDeductionFeedHttpHandler;
import com.personal.business.employeedeductionfeed.update.routes.UpdateEmployeeDeductionFeedHttpHandler;

import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;

public class EmployeeDeductionFeedRouter implements HttpService {

    @Override
    public void routing(HttpRules rules) {
        rules.post("/", new CreateEmployeeDeductionFeedHttpHandler()::Post);
        rules.put("/", new UpdateEmployeeDeductionFeedHttpHandler()::Put);
        rules.delete("/{id}", new DeleteEmployeeDeductionFeedHttpHandler()::Delete);
        rules.post("/filter", new FilterEmployeeDeductionFeedHttpHandler()::Post);
    }
}
