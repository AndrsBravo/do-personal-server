package com.personal.business.employeescale.filter.routes;

import com.personal.business.employeescale.filter.inputs.FilterEmployeeScaleInput;
import com.personal.business.employeescale.filter.process.FilterEmployeeScaleProcessExecutor;
import com.personal.shared.http.Response;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class FilterEmployeeScaleHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var employeeScaleFilterInput = request.content().as(FilterEmployeeScaleInput.class);
        var employeeScaleProcess = FilterEmployeeScaleProcessExecutor.builder().init(employeeScaleFilterInput).execute();

        switch (employeeScaleProcess.state()) {
            case STOP_WITH_ERROR ->
                response.status(Status.NO_CONTENT_204).send(Response.error("204", employeeScaleProcess.getCurrentLog()));

            default ->
                response.status(Status.OK_200).send(Response.success(employeeScaleProcess.getResult()));
        }
    }

}
