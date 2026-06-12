package com.personal.business.employeebenefitfeed.update.routes;

import com.personal.business.employeebenefitfeed.create.inputs.EmployeeBenefitFeedInput;
import com.personal.business.employeebenefitfeed.update.process.UpdateEmployeeBenefitFeedProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class UpdateEmployeeBenefitFeedHttpHandler {

    public void Put(ServerRequest request, ServerResponse response) {
        var employeeBenefitFeed = request.content().as(EmployeeBenefitFeedInput.class);

        var updateEmployeeBenefitFeed = UpdateEmployeeBenefitFeedProcessExecutor.builder()
                .init(employeeBenefitFeed.getEmployeeBenefitFeed())
                .execute();

        switch (updateEmployeeBenefitFeed.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(updateEmployeeBenefitFeed.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(updateEmployeeBenefitFeed.getInitObject());
        }
    }

}
