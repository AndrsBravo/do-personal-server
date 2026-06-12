package com.personal.business.employeebenefit.api.routers;

import com.personal.business.employeebenefit.create.routes.CreateEmployeeBenefitHttpHandler;
import com.personal.business.employeebenefit.delete.routes.DeleteEmployeeBenefitHttpHandler;
import com.personal.business.employeebenefit.filter.routes.FilterEmployeeBenefitHttpHandler;
import com.personal.business.employeebenefit.update.routes.UpdateEmployeeBenefitHttpHandler;

import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;

public class EmployeeBenefitRouter implements HttpService {

    @Override
    public void routing(HttpRules rules) {
        rules.post("/", new CreateEmployeeBenefitHttpHandler()::Post);
        rules.put("/", new UpdateEmployeeBenefitHttpHandler()::Put);
        rules.delete("/{id}", new DeleteEmployeeBenefitHttpHandler()::Delete);
        rules.post("/filter", new FilterEmployeeBenefitHttpHandler()::Post);
    }
}
