package com.personal.business.employee.filter.routes;

import com.personal.business.employee.filter.inputs.FilterEmployeeInput;
import com.personal.business.employee.filter.process.FilterEmployeeProcessExecutor;
import com.personal.shared.http.Response;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class FilterEmployeeHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var employeeFilterInput = request.content().as(FilterEmployeeInput.class);
        var employeeProcess = FilterEmployeeProcessExecutor.builder().init(employeeFilterInput).execute();

        switch (employeeProcess.state()) {
            case STOP_WITH_ERROR ->
                response.status(Status.NO_CONTENT_204).send(Response.error("204", employeeProcess.getCurrentLog()));

            default ->
                response.status(Status.OK_200).send(Response.success(employeeProcess.getResult()));
        }
    }

}
