package com.personal.business.employeebenefitfeed.api.routers;

import com.personal.business.employeebenefitfeed.create.routes.CreateEmployeeBenefitFeedHttpHandler;
import com.personal.business.employeebenefitfeed.delete.routes.DeleteEmployeeBenefitFeedHttpHandler;
import com.personal.business.employeebenefitfeed.filter.routes.FilterEmployeeBenefitFeedHttpHandler;
import com.personal.business.employeebenefitfeed.update.routes.UpdateEmployeeBenefitFeedHttpHandler;

import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;

public class EmployeeBenefitFeedRouter implements HttpService {

    @Override
    public void routing(HttpRules rules) {
        rules.post("/", new CreateEmployeeBenefitFeedHttpHandler()::Post);
        rules.put("/", new UpdateEmployeeBenefitFeedHttpHandler()::Put);
        rules.delete("/{id}", new DeleteEmployeeBenefitFeedHttpHandler()::Delete);
        rules.post("/filter", new FilterEmployeeBenefitFeedHttpHandler()::Post);
    }
}
