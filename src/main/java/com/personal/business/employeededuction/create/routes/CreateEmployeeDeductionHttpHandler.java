package com.personal.business.employeededuction.create.routes;

import com.personal.business.employeededuction.create.inputs.EmployeeDeductionInput;
import com.personal.business.employeededuction.create.process.CreateEmployeeDeductionProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class CreateEmployeeDeductionHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var employeeDeduction = request.content().as(EmployeeDeductionInput.class);

        var createEmployeeDeduction = CreateEmployeeDeductionProcessExecutor.builder()
                .init(employeeDeduction.getEmployeeDeduction())
                .execute();
        switch (createEmployeeDeduction.state()) {
            case COMPLETED ->
                response.status(Status.CREATED_201).send(createEmployeeDeduction.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(createEmployeeDeduction.getInitObject());
        }
    }
}
