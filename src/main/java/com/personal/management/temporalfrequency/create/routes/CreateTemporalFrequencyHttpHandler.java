package com.personal.management.temporalfrequency.create.routes;

import com.personal.management.temporalfrequency.create.inputs.TemporalFrequencyInput;
import com.personal.management.temporalfrequency.create.process.CreateTemporalFrequencyProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class CreateTemporalFrequencyHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var temporalFrequency = request.content().as(TemporalFrequencyInput.class);

        var createTemporalFrequency = CreateTemporalFrequencyProcessExecutor.builder()
                .init(temporalFrequency.getTemporalFrequency())
                .execute();
        switch (createTemporalFrequency.state()) {
            case COMPLETED ->
                response.status(Status.CREATED_201).send(createTemporalFrequency.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(createTemporalFrequency.getInitObject());
        }
    }
}
