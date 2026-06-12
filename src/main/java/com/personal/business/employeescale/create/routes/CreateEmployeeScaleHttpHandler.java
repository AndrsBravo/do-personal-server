package com.personal.business.employeescale.create.routes;

import com.personal.business.employeescale.create.inputs.EmployeeScaleInput;
import com.personal.business.employeescale.create.process.CreateEmployeeScaleProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class CreateEmployeeScaleHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var employeeScale = request.content().as(EmployeeScaleInput.class);

        var createEmployeeScale = CreateEmployeeScaleProcessExecutor.builder()
                .init(employeeScale.getEmployeeScale())
                .execute();
        switch (createEmployeeScale.state()) {
            case COMPLETED ->
                response.status(Status.CREATED_201).send(createEmployeeScale.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(createEmployeeScale.getInitObject());
        }
    }
}
