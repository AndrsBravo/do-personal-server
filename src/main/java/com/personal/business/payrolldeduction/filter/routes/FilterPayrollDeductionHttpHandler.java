package com.personal.business.payrolldeduction.filter.routes;

import com.personal.business.payrolldeduction.filter.inputs.FilterPayrollDeductionInput;
import com.personal.business.payrolldeduction.filter.process.FilterPayrollDeductionProcessExecutor;
import com.personal.shared.http.Response;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class FilterPayrollDeductionHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var payrollDeductionFilterInput = request.content().as(FilterPayrollDeductionInput.class);
        var payrollDeductionProcess = FilterPayrollDeductionProcessExecutor.builder().init(payrollDeductionFilterInput).execute();

        switch (payrollDeductionProcess.state()) {
            case STOP_WITH_ERROR ->
                response.status(Status.NO_CONTENT_204).send(Response.error("204", payrollDeductionProcess.getCurrentLog()));

            default ->
                response.status(Status.OK_200).send(Response.success(payrollDeductionProcess.getResult()));
        }
    }

}
