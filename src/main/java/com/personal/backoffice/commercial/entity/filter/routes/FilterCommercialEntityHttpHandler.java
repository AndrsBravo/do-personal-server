package com.personal.backoffice.commercial.entity.filter.routes;

import com.personal.backoffice.commercial.entity.filter.inputs.FilterCommercialEntityInput;
import com.personal.backoffice.commercial.entity.filter.process.FilterCommercialEntityProcessExecutor;
import com.personal.shared.http.Response;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class FilterCommercialEntityHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var commercialEntityFilterInput = request.content().as(FilterCommercialEntityInput.class);
        var commercialEntityProcess = FilterCommercialEntityProcessExecutor.builder().init(commercialEntityFilterInput).execute();
        if (commercialEntityProcess.state() == ProcessState.STOP_WITH_ERROR) {
            response.status(Status.NO_CONTENT_204).send(Response.error("204", commercialEntityProcess.getCurrentLog()));
            return;
        }
        response.status(Status.OK_200).send(Response.success(commercialEntityProcess.getResult()));
    }

}
