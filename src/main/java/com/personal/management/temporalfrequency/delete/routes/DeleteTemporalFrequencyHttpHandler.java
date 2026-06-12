package com.personal.management.temporalfrequency.delete.routes;

import com.personal.management.temporalfrequency.delete.process.DeleteTemporalFrequencyProcessExecutor;
import com.personal.management.temporalfrequency.entities.TemporalFrequency;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class DeleteTemporalFrequencyHttpHandler {

    public void Delete(ServerRequest request, ServerResponse response) {
        var id = request.path().pathParameters().get("id");

        //System.out.println("El id a eliminar " + id);
        var temporalFrequency = new TemporalFrequency(id);

        var deleteTemporalFrequency = DeleteTemporalFrequencyProcessExecutor.builder()
                .init(temporalFrequency)
                .execute();

        switch (deleteTemporalFrequency.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(deleteTemporalFrequency.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(deleteTemporalFrequency.getInitObject());
        }
    }

}
