package com.personal.business.employeebenefitfeed.create.routes;

import com.personal.business.employeebenefitfeed.create.inputs.EmployeeBenefitFeedInput;
import com.personal.business.employeebenefitfeed.create.process.CreateEmployeeBenefitFeedProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class CreateEmployeeBenefitFeedHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var employeeBenefitFeed = request.content().as(EmployeeBenefitFeedInput.class);

        var createEmployeeBenefitFeed = CreateEmployeeBenefitFeedProcessExecutor.builder()
                .init(employeeBenefitFeed.getEmployeeBenefitFeed())
                .execute();
        switch (createEmployeeBenefitFeed.state()) {
            case COMPLETED ->
                response.status(Status.CREATED_201).send(createEmployeeBenefitFeed.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(createEmployeeBenefitFeed.getInitObject());
        }
    }
}
