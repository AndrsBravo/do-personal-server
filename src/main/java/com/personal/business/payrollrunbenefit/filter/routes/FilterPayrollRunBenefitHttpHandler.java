package com.personal.business.payrollrunbenefit.filter.routes;

import com.personal.business.payrollrunbenefit.filter.inputs.FilterPayrollRunBenefitInput;
import com.personal.business.payrollrunbenefit.filter.process.FilterPayrollRunBenefitProcessExecutor;
import com.personal.shared.http.Response;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class FilterPayrollRunBenefitHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var payrollRunBenefitFilterInput = request.content().as(FilterPayrollRunBenefitInput.class);
        var payrollRunBenefitProcess = FilterPayrollRunBenefitProcessExecutor.builder().init(payrollRunBenefitFilterInput).execute();

        switch (payrollRunBenefitProcess.state()) {
            case STOP_WITH_ERROR ->
                response.status(Status.NO_CONTENT_204).send(Response.error("204", payrollRunBenefitProcess.getCurrentLog()));

            default ->
                response.status(Status.OK_200).send(Response.success(payrollRunBenefitProcess.getResult()));
        }
    }

}
