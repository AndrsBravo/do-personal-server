package com.personal.business.hierarchybenefitfeed.filter.routes;

import com.personal.business.hierarchybenefitfeed.filter.inputs.FilterHierarchyBenefitFeedInput;
import com.personal.business.hierarchybenefitfeed.filter.process.FilterHierarchyBenefitFeedProcessExecutor;
import com.personal.shared.http.Response;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class FilterHierarchyBenefitFeedHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var hierarchyBenefitFeedFilterInput = request.content().as(FilterHierarchyBenefitFeedInput.class);
        var hierarchyBenefitFeedProcess = FilterHierarchyBenefitFeedProcessExecutor.builder().init(hierarchyBenefitFeedFilterInput).execute();

        switch (hierarchyBenefitFeedProcess.state()) {
            case STOP_WITH_ERROR ->
                response.status(Status.NO_CONTENT_204).send(Response.error("204", hierarchyBenefitFeedProcess.getCurrentLog()));

            default ->
                response.status(Status.OK_200).send(Response.success(hierarchyBenefitFeedProcess.getResult()));
        }
    }

}
