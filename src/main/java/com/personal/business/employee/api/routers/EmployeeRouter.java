package com.personal.business.employee.api.routers;

import com.personal.business.employee.create.routes.CreateEmployeeHttpHandler;
import com.personal.business.employee.delete.routes.DeleteEmployeeHttpHandler;
import com.personal.business.employee.filter.routes.FilterEmployeeHttpHandler;
import com.personal.business.employee.update.routes.UpdateEmployeeHttpHandler;

import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;

public class EmployeeRouter implements HttpService {

    @Override
    public void routing(HttpRules rules) {
        rules.post("/", new CreateEmployeeHttpHandler()::Post);
        rules.put("/", new UpdateEmployeeHttpHandler()::Put);
        rules.delete("/{id}", new DeleteEmployeeHttpHandler()::Delete);
        rules.post("/filter", new FilterEmployeeHttpHandler()::Post);
    }
}
