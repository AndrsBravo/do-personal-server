package com.personal.management.payrollbenefit.filter.routes;

import com.personal.management.payrollbenefit.filter.inputs.FilterPayrollBenefitInput;
import com.personal.management.payrollbenefit.filter.process.FilterPayrollBenefitProcessExecutor;
import com.personal.shared.http.Response;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class FilterPayrollBenefitHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var payrollBenefitFilterInput = request.content().as(FilterPayrollBenefitInput.class);
        var payrollBenefitProcess = FilterPayrollBenefitProcessExecutor.builder().init(payrollBenefitFilterInput).execute();

        switch (payrollBenefitProcess.state()) {
            case STOP_WITH_ERROR ->
                response.status(Status.NO_CONTENT_204).send(Response.error("204", payrollBenefitProcess.getCurrentLog()));

            default ->
                response.status(Status.OK_200).send(Response.success(payrollBenefitProcess.getResult()));
        }
    }

}
