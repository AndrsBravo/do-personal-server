package com.personal.backoffice.business.api.routes;

import com.personal.backoffice.business.api.inputs.FilterBusinessInput;
import com.personal.backoffice.business.process.filter.FilterBusinessProcessExecutor;
import com.personal.shared.http.Response;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class FilterBusinessHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var businessFilterInput = request.content().as(FilterBusinessInput.class);
        var businessProcess = FilterBusinessProcessExecutor.builder().init(businessFilterInput).execute();
        if (businessProcess.state() == ProcessState.STOP_WITH_ERROR) {
            response.status(Status.NO_CONTENT_204).send(Response.error("204", businessProcess.getCurrentLog()));
            return;
        }
        response.status(Status.OK_200).send(Response.success(businessProcess.getResult()));
    }

}
