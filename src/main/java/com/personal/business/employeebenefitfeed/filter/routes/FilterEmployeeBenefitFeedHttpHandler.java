package com.personal.business.employeebenefitfeed.filter.routes;

import com.personal.business.employeebenefitfeed.filter.inputs.FilterEmployeeBenefitFeedInput;
import com.personal.business.employeebenefitfeed.filter.process.FilterEmployeeBenefitFeedProcessExecutor;
import com.personal.shared.http.Response;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class FilterEmployeeBenefitFeedHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var employeeBenefitFeedFilterInput = request.content().as(FilterEmployeeBenefitFeedInput.class);
        var employeeBenefitFeedProcess = FilterEmployeeBenefitFeedProcessExecutor.builder().init(employeeBenefitFeedFilterInput).execute();

        switch (employeeBenefitFeedProcess.state()) {
            case STOP_WITH_ERROR ->
                response.status(Status.NO_CONTENT_204).send(Response.error("204", employeeBenefitFeedProcess.getCurrentLog()));

            default ->
                response.status(Status.OK_200).send(Response.success(employeeBenefitFeedProcess.getResult()));
        }
    }

}
