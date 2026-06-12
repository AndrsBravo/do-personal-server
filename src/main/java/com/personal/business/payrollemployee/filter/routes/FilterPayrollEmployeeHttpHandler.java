package com.personal.business.payrollemployee.filter.routes;

import com.personal.business.payrollemployee.filter.inputs.FilterPayrollEmployeeInput;
import com.personal.business.payrollemployee.filter.process.FilterPayrollEmployeeProcessExecutor;
import com.personal.shared.http.Response;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class FilterPayrollEmployeeHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var payrollEmployeeFilterInput = request.content().as(FilterPayrollEmployeeInput.class);
        var payrollEmployeeProcess = FilterPayrollEmployeeProcessExecutor.builder().init(payrollEmployeeFilterInput).execute();

        switch (payrollEmployeeProcess.state()) {
            case STOP_WITH_ERROR ->
                response.status(Status.NO_CONTENT_204).send(Response.error("204", payrollEmployeeProcess.getCurrentLog()));

            default ->
                response.status(Status.OK_200).send(Response.success(payrollEmployeeProcess.getResult()));
        }
    }

}
