package com.personal.business.employeededuction.api.routers;

import com.personal.business.employeededuction.create.routes.CreateEmployeeDeductionHttpHandler;
import com.personal.business.employeededuction.delete.routes.DeleteEmployeeDeductionHttpHandler;
import com.personal.business.employeededuction.filter.routes.FilterEmployeeDeductionHttpHandler;
import com.personal.business.employeededuction.update.routes.UpdateEmployeeDeductionHttpHandler;

import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;

public class EmployeeDeductionRouter implements HttpService {

    @Override
    public void routing(HttpRules rules) {
        rules.post("/", new CreateEmployeeDeductionHttpHandler()::Post);
        rules.put("/", new UpdateEmployeeDeductionHttpHandler()::Put);
        rules.delete("/{id}", new DeleteEmployeeDeductionHttpHandler()::Delete);
        rules.post("/filter", new FilterEmployeeDeductionHttpHandler()::Post);
    }
}
