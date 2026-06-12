package com.personal.business.hierarchydeductionfeed.filter.routes;

import com.personal.business.hierarchydeductionfeed.filter.inputs.FilterHierarchyDeductionFeedInput;
import com.personal.business.hierarchydeductionfeed.filter.process.FilterHierarchyDeductionFeedProcessExecutor;
import com.personal.shared.http.Response;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class FilterHierarchyDeductionFeedHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var hierarchyDeductionFeedFilterInput = request.content().as(FilterHierarchyDeductionFeedInput.class);
        var hierarchyDeductionFeedProcess = FilterHierarchyDeductionFeedProcessExecutor.builder().init(hierarchyDeductionFeedFilterInput).execute();

        switch (hierarchyDeductionFeedProcess.state()) {
            case STOP_WITH_ERROR ->
                response.status(Status.NO_CONTENT_204).send(Response.error("204", hierarchyDeductionFeedProcess.getCurrentLog()));

            default ->
                response.status(Status.OK_200).send(Response.success(hierarchyDeductionFeedProcess.getResult()));
        }
    }

}
