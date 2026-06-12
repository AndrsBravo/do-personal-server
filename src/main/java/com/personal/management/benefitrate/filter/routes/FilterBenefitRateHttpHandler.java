package com.personal.management.benefitrate.filter.routes;

import com.personal.management.benefitrate.filter.inputs.FilterBenefitRateInput;
import com.personal.management.benefitrate.filter.process.FilterBenefitRateProcessExecutor;
import com.personal.shared.http.Response;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class FilterBenefitRateHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var benefitFilterInput = request.content().as(FilterBenefitRateInput.class);
        var benefitProcess = FilterBenefitRateProcessExecutor.builder().init(benefitFilterInput).execute();

        switch (benefitProcess.state()) {
            case STOP_WITH_ERROR ->
                response.status(Status.NO_CONTENT_204).send(Response.error("204", benefitProcess.getCurrentLog()));

            default ->
                response.status(Status.OK_200).send(Response.success(benefitProcess.getResult()));
        }
    }

}
