package com.personal.business.orgstructure.filter.routes;

import com.personal.business.orgstructure.filter.inputs.FilterOrgStructureInput;
import com.personal.business.orgstructure.filter.process.FilterOrgStructureProcessExecutor;
import com.personal.shared.http.Response;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class FilterOrgStructureHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var orgStructureFilterInput = request.content().as(FilterOrgStructureInput.class);
        var orgStructureProcess = FilterOrgStructureProcessExecutor.builder().init(orgStructureFilterInput).execute();

        switch (orgStructureProcess.state()) {
            case STOP_WITH_ERROR ->
                response.status(Status.NO_CONTENT_204).send(Response.error("204", orgStructureProcess.getCurrentLog()));

            default ->
                response.status(Status.OK_200).send(Response.success(orgStructureProcess.getResult()));
        }
    }

}
