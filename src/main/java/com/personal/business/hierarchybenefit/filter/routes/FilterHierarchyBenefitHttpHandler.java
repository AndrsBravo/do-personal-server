package com.personal.business.hierarchybenefit.filter.routes;

import com.personal.business.hierarchybenefit.filter.inputs.FilterHierarchyBenefitInput;
import com.personal.business.hierarchybenefit.filter.process.FilterHierarchyBenefitProcessExecutor;
import com.personal.shared.http.Response;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class FilterHierarchyBenefitHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var hierarchyBenefitFilterInput = request.content().as(FilterHierarchyBenefitInput.class);
        var hierarchyBenefitProcess = FilterHierarchyBenefitProcessExecutor.builder().init(hierarchyBenefitFilterInput).execute();

        switch (hierarchyBenefitProcess.state()) {
            case STOP_WITH_ERROR ->
                response.status(Status.NO_CONTENT_204).send(Response.error("204", hierarchyBenefitProcess.getCurrentLog()));

            default ->
                response.status(Status.OK_200).send(Response.success(hierarchyBenefitProcess.getResult()));
        }
    }

}
