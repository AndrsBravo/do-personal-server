package com.personal.business.temporalfrequency.filter.routes;

import com.personal.business.temporalfrequency.filter.inputs.FilterTemporalFrequencyInput;
import com.personal.business.temporalfrequency.filter.process.FilterTemporalFrequencyProcessExecutor;
import com.personal.shared.http.Response;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class FilterTemporalFrequencyHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var temporalFrequencyFilterInput = request.content().as(FilterTemporalFrequencyInput.class);
        var temporalFrequencyProcess = FilterTemporalFrequencyProcessExecutor.builder().init(temporalFrequencyFilterInput).execute();

        switch (temporalFrequencyProcess.state()) {
            case STOP_WITH_ERROR ->
                response.status(Status.NO_CONTENT_204).send(Response.error("204", temporalFrequencyProcess.getCurrentLog()));

            default ->
                response.status(Status.OK_200).send(Response.success(temporalFrequencyProcess.getResult()));
        }
    }

}
