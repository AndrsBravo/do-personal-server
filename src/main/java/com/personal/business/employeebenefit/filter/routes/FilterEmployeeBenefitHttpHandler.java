package com.personal.business.employeebenefit.filter.routes;

import com.personal.business.employeebenefit.filter.inputs.FilterEmployeeBenefitInput;
import com.personal.business.employeebenefit.filter.process.FilterEmployeeBenefitProcessExecutor;
import com.personal.shared.http.Response;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class FilterEmployeeBenefitHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var employeeBenefitFilterInput = request.content().as(FilterEmployeeBenefitInput.class);
        var employeeBenefitProcess = FilterEmployeeBenefitProcessExecutor.builder().init(employeeBenefitFilterInput).execute();

        switch (employeeBenefitProcess.state()) {
            case STOP_WITH_ERROR ->
                response.status(Status.NO_CONTENT_204).send(Response.error("204", employeeBenefitProcess.getCurrentLog()));

            default ->
                response.status(Status.OK_200).send(Response.success(employeeBenefitProcess.getResult()));
        }
    }

}
