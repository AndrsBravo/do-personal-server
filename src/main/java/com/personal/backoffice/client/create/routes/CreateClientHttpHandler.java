package com.personal.backoffice.client.create.routes;

import com.personal.backoffice.client.create.inputs.ClientInput;
import com.personal.backoffice.client.create.process.CreateClientProcessExecutor;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class CreateClientHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var client = request.content().as(ClientInput.class);

        var createClient = CreateClientProcessExecutor.builder()
                .init(client.getClient())
                .execute();
        if (createClient.state() == ProcessState.COMPLETED) {
            response.status(Status.CREATED_201).send(createClient.getInitObject());
            return;
        }
        response.status(Status.ACCEPTED_202).send(createClient.getInitObject());
    }
}
