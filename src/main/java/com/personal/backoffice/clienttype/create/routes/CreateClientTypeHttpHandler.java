package com.personal.backoffice.clienttype.create.routes;

import com.personal.backoffice.clienttype.create.process.CreateClientTypeProcessExecutor;
import com.personal.shared.inputs.BaseTypeInput;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class CreateClientTypeHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var clientType = request.content().as(BaseTypeInput.class);

        var createClientType = CreateClientTypeProcessExecutor.builder()
                .init(clientType.getType())
                .execute();
        if (createClientType.state() == ProcessState.COMPLETED) {
            response.status(Status.CREATED_201).send(createClientType.getInitObject());
            return;
        }
        response.status(Status.ACCEPTED_202).send(createClientType.getInitObject());
    }
}
