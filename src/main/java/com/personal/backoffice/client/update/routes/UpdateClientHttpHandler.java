package com.personal.backoffice.client.update.routes;

import com.personal.backoffice.client.create.inputs.ClientInput;
import com.personal.backoffice.client.update.process.UpdateClientProcessExecutor;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class UpdateClientHttpHandler {

    public void Put(ServerRequest request, ServerResponse response) {
        var client = request.content().as(ClientInput.class);

        var updateClient = UpdateClientProcessExecutor.builder()
                .init(client.getClient())
                .execute();

        if (updateClient.state() == ProcessState.COMPLETED) {
            response.status(Status.OK_200).send(updateClient.getInitObject());
            return;
        }
        response.status(Status.ACCEPTED_202).send(updateClient.getInitObject());
    }

}
