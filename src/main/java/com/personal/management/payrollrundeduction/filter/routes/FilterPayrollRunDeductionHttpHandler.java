package com.personal.management.payrollrundeduction.filter.routes;

import com.personal.management.payrollrundeduction.filter.inputs.FilterPayrollRunDeductionInput;
import com.personal.management.payrollrundeduction.filter.process.FilterPayrollRunDeductionProcessExecutor;
import com.personal.shared.http.Response;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class FilterPayrollRunDeductionHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var payrollRunDeductionFilterInput = request.content().as(FilterPayrollRunDeductionInput.class);
        var payrollRunDeductionProcess = FilterPayrollRunDeductionProcessExecutor.builder().init(payrollRunDeductionFilterInput).execute();

        switch (payrollRunDeductionProcess.state()) {
            case STOP_WITH_ERROR ->
                response.status(Status.NO_CONTENT_204).send(Response.error("204", payrollRunDeductionProcess.getCurrentLog()));

            default ->
                response.status(Status.OK_200).send(Response.success(payrollRunDeductionProcess.getResult()));
        }
    }

}
