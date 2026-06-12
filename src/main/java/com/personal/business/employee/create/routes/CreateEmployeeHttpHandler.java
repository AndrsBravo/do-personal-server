package com.personal.business.employee.create.routes;

import com.personal.business.employee.create.inputs.EmployeeInput;
import com.personal.business.employee.create.process.CreateEmployeeProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class CreateEmployeeHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var employee = request.content().as(EmployeeInput.class);

        var createEmployee = CreateEmployeeProcessExecutor.builder()
                .init(employee.getEmployee())
                .execute();
        switch (createEmployee.state()) {
            case COMPLETED ->
                response.status(Status.CREATED_201).send(createEmployee.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(createEmployee.getInitObject());
        }
    }
}
