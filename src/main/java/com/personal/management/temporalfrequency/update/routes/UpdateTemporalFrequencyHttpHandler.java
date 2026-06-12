package com.personal.management.temporalfrequency.update.routes;

import com.personal.management.temporalfrequency.create.inputs.TemporalFrequencyInput;
import com.personal.management.temporalfrequency.update.process.UpdateTemporalFrequencyProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class UpdateTemporalFrequencyHttpHandler {

    public void Put(ServerRequest request, ServerResponse response) {
        var temporalFrequency = request.content().as(TemporalFrequencyInput.class);

        var updateTemporalFrequency = UpdateTemporalFrequencyProcessExecutor.builder()
                .init(temporalFrequency.getTemporalFrequency())
                .execute();

        switch (updateTemporalFrequency.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(updateTemporalFrequency.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(updateTemporalFrequency.getInitObject());
        }
    }

}
