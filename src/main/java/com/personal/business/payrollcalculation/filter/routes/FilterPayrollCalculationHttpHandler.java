package com.personal.business.payrollcalculation.filter.routes;

import com.personal.business.payrollcalculation.filter.inputs.FilterPayrollCalculationInput;
import com.personal.business.payrollcalculation.filter.process.FilterPayrollCalculationProcessExecutor;
import com.personal.shared.http.Response;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class FilterPayrollCalculationHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var payrollFilterInput = request.content().as(FilterPayrollCalculationInput.class);
        var payrollProcess = FilterPayrollCalculationProcessExecutor.builder().init(payrollFilterInput).execute();

        switch (payrollProcess.state()) {
            case STOP_WITH_ERROR ->
                response.status(Status.NO_CONTENT_204).send(Response.error("204", payrollProcess.getCurrentLog()));

            default ->
                response.status(Status.OK_200).send(Response.success(payrollProcess.getResult()));
        }
    }

}
