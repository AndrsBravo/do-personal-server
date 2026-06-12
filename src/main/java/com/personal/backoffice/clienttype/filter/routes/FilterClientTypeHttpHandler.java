package com.personal.backoffice.clienttype.filter.routes;

import com.personal.backoffice.clienttype.filter.process.FilterClientTypeProcessExecutor;
import com.personal.shared.http.Response;
import com.personal.shared.inputs.FilterTypeInput;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class FilterClientTypeHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var clientTypesFilterInput = request.content().as(FilterTypeInput.class);
        var clientTypeProcess = FilterClientTypeProcessExecutor.builder().init(clientTypesFilterInput).execute();
        if (clientTypeProcess.state() == ProcessState.STOP_WITH_ERROR) {
            response.status(Status.NO_CONTENT_204).send(Response.error("204", clientTypeProcess.getCurrentLog()));
            return;
        }
        response.status(Status.OK_200).send(Response.success(clientTypeProcess.getResult()));
    }

}
