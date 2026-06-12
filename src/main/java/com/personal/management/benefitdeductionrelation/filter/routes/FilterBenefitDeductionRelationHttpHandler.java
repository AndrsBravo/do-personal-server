package com.personal.management.benefitdeductionrelation.filter.routes;

import com.personal.management.benefitdeductionrelation.filter.inputs.FilterBenefitDeductionRelationInput;
import com.personal.management.benefitdeductionrelation.filter.process.FilterBenefitDeductionRelationProcessExecutor;
import com.personal.shared.http.Response;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class FilterBenefitDeductionRelationHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var benefitDeductionRelationFilterInput = request.content().as(FilterBenefitDeductionRelationInput.class);
        var benefitDeductionRelationProcess = FilterBenefitDeductionRelationProcessExecutor.builder().init(benefitDeductionRelationFilterInput).execute();

        switch (benefitDeductionRelationProcess.state()) {
            case STOP_WITH_ERROR ->
                response.status(Status.NO_CONTENT_204).send(Response.error("204", benefitDeductionRelationProcess.getCurrentLog()));

            default ->
                response.status(Status.OK_200).send(Response.success(benefitDeductionRelationProcess.getResult()));
        }
    }

}
