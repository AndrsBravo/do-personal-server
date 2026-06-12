package com.personal.business.employeededuction.filter.routes;

import com.personal.business.employeededuction.filter.inputs.FilterEmployeeDeductionInput;
import com.personal.business.employeededuction.filter.process.FilterEmployeeDeductionProcessExecutor;
import com.personal.shared.http.Response;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class FilterEmployeeDeductionHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var employeeDeductionFilterInput = request.content().as(FilterEmployeeDeductionInput.class);
        var employeeDeductionProcess = FilterEmployeeDeductionProcessExecutor.builder().init(employeeDeductionFilterInput).execute();

        switch (employeeDeductionProcess.state()) {
            case STOP_WITH_ERROR ->
                response.status(Status.NO_CONTENT_204).send(Response.error("204", employeeDeductionProcess.getCurrentLog()));

            default ->
                response.status(Status.OK_200).send(Response.success(employeeDeductionProcess.getResult()));
        }
    }

}
