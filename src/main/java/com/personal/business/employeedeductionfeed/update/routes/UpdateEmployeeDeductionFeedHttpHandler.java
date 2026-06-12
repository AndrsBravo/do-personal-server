package com.personal.business.employeedeductionfeed.update.routes;

import com.personal.business.employeedeductionfeed.create.inputs.EmployeeDeductionFeedInput;
import com.personal.business.employeedeductionfeed.update.process.UpdateEmployeeDeductionFeedProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class UpdateEmployeeDeductionFeedHttpHandler {

    public void Put(ServerRequest request, ServerResponse response) {
        var employeeDeductionFeed = request.content().as(EmployeeDeductionFeedInput.class);

        var updateEmployeeDeductionFeed = UpdateEmployeeDeductionFeedProcessExecutor.builder()
                .init(employeeDeductionFeed.getEmployeeDeductionFeed())
                .execute();

        switch (updateEmployeeDeductionFeed.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(updateEmployeeDeductionFeed.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(updateEmployeeDeductionFeed.getInitObject());
        }
    }

}
