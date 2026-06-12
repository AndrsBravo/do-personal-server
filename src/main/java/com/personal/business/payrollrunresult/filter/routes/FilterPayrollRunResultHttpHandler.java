package com.personal.business.payrollrunresult.filter.routes;

import com.personal.business.payrollrunresult.filter.inputs.FilterPayrollRunResultInput;
import com.personal.business.payrollrunresult.filter.process.FilterPayrollRunResultProcessExecutor;
import com.personal.shared.http.Response;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class FilterPayrollRunResultHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var payrollFilterInput = request.content().as(FilterPayrollRunResultInput.class);
        var payrollProcess = FilterPayrollRunResultProcessExecutor.builder().init(payrollFilterInput).execute();

        switch (payrollProcess.state()) {
            case STOP_WITH_ERROR ->
                response.status(Status.NO_CONTENT_204).send(Response.error("204", payrollProcess.getCurrentLog()));

            default ->
                response.status(Status.OK_200).send(Response.success(payrollProcess.getResult()));
        }
    }

}
