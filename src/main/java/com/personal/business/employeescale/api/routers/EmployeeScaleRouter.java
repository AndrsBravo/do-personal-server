package com.personal.business.employeescale.api.routers;

import com.personal.business.employeescale.create.routes.CreateEmployeeScaleHttpHandler;
import com.personal.business.employeescale.delete.routes.DeleteEmployeeScaleHttpHandler;
import com.personal.business.employeescale.filter.routes.FilterEmployeeScaleHttpHandler;
import com.personal.business.employeescale.update.routes.UpdateEmployeeScaleHttpHandler;

import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;

public class EmployeeScaleRouter implements HttpService {

    @Override
    public void routing(HttpRules rules) {
        rules.post("/", new CreateEmployeeScaleHttpHandler()::Post);
        rules.put("/", new UpdateEmployeeScaleHttpHandler()::Put);
        rules.delete("/{id}", new DeleteEmployeeScaleHttpHandler()::Delete);
        rules.post("/filter", new FilterEmployeeScaleHttpHandler()::Post);
    }
}
