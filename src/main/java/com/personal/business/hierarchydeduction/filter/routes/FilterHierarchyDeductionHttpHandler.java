package com.personal.business.hierarchydeduction.filter.routes;

import com.personal.business.hierarchydeduction.filter.inputs.FilterHierarchyDeductionInput;
import com.personal.business.hierarchydeduction.filter.process.FilterHierarchyDeductionProcessExecutor;
import com.personal.shared.http.Response;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class FilterHierarchyDeductionHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var hierarchyDeductionFilterInput = request.content().as(FilterHierarchyDeductionInput.class);
        var hierarchyDeductionProcess = FilterHierarchyDeductionProcessExecutor.builder().init(hierarchyDeductionFilterInput).execute();

        switch (hierarchyDeductionProcess.state()) {
            case STOP_WITH_ERROR ->
                response.status(Status.NO_CONTENT_204).send(Response.error("204", hierarchyDeductionProcess.getCurrentLog()));

            default ->
                response.status(Status.OK_200).send(Response.success(hierarchyDeductionProcess.getResult()));
        }
    }

}
