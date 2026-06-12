package com.personal.business.employeedeductionfeed.filter.routes;

import com.personal.business.employeedeductionfeed.filter.inputs.FilterEmployeeDeductionFeedInput;
import com.personal.business.employeedeductionfeed.filter.process.FilterEmployeeDeductionFeedProcessExecutor;
import com.personal.shared.http.Response;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class FilterEmployeeDeductionFeedHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var employeeDeductionFeedFilterInput = request.content().as(FilterEmployeeDeductionFeedInput.class);
        var employeeDeductionFeedProcess = FilterEmployeeDeductionFeedProcessExecutor.builder().init(employeeDeductionFeedFilterInput).execute();

        switch (employeeDeductionFeedProcess.state()) {
            case STOP_WITH_ERROR ->
                response.status(Status.NO_CONTENT_204).send(Response.error("204", employeeDeductionFeedProcess.getCurrentLog()));

            default ->
                response.status(Status.OK_200).send(Response.success(employeeDeductionFeedProcess.getResult()));
        }
    }

}
