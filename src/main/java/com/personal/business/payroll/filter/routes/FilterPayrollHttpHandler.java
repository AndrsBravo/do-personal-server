package com.personal.business.payroll.filter.routes;

import com.personal.business.payroll.filter.inputs.FilterPayrollInput;
import com.personal.business.payroll.filter.process.FilterPayrollProcessExecutor;
import com.personal.shared.http.Response;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class FilterPayrollHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var payrollFilterInput = request.content().as(FilterPayrollInput.class);
        var payrollProcess = FilterPayrollProcessExecutor.builder().init(payrollFilterInput).execute();

        switch (payrollProcess.state()) {
            case STOP_WITH_ERROR ->
                response.status(Status.NO_CONTENT_204).send(Response.error("204", payrollProcess.getCurrentLog()));

            default ->
                response.status(Status.OK_200).send(Response.success(payrollProcess.getResult()));
        }
    }

}
