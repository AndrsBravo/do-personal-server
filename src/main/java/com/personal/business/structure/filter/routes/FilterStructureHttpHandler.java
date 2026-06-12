package com.personal.business.structure.filter.routes;

import com.personal.business.structure.filter.inputs.FilterStructureInput;
import com.personal.business.structure.filter.process.FilterStructureProcessExecutor;
import com.personal.shared.http.Response;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class FilterStructureHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var structureFilterInput = request.content().as(FilterStructureInput.class);
        var structureProcess = FilterStructureProcessExecutor.builder().init(structureFilterInput).execute();

        switch (structureProcess.state()) {
            case STOP_WITH_ERROR ->
                response.status(Status.NO_CONTENT_204).send(Response.error("204", structureProcess.getCurrentLog()));

            default ->
                response.status(Status.OK_200).send(Response.success(structureProcess.getResult()));
        }
    }

}
