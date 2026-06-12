package com.personal.business.employeedeductionfeed.create.routes;

import com.personal.business.employeedeductionfeed.create.inputs.EmployeeDeductionFeedInput;
import com.personal.business.employeedeductionfeed.create.process.CreateEmployeeDeductionFeedProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class CreateEmployeeDeductionFeedHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var employeeDeductionFeed = request.content().as(EmployeeDeductionFeedInput.class);

        var createEmployeeDeductionFeed = CreateEmployeeDeductionFeedProcessExecutor.builder()
                .init(employeeDeductionFeed.getEmployeeDeductionFeed())
                .execute();
        switch (createEmployeeDeductionFeed.state()) {
            case COMPLETED ->
                response.status(Status.CREATED_201).send(createEmployeeDeductionFeed.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(createEmployeeDeductionFeed.getInitObject());
        }
    }
}
