package com.personal.backoffice.clienttype.update.routes;

import com.personal.backoffice.clienttype.update.process.UpdateClientTypeProcessExecutor;
import com.personal.shared.inputs.BaseTypeInput;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class UpdateClientTypeHttpHandler {

    public void Put(ServerRequest request, ServerResponse response) {
        var clientType = request.content().as(BaseTypeInput.class);

        var updateClientType = UpdateClientTypeProcessExecutor.builder()
                .init(clientType.getType())
                .execute();

        if (updateClientType.state() == ProcessState.COMPLETED) {
            response.status(Status.OK_200).send(updateClientType.getInitObject());
            return;
        }
        response.status(Status.ACCEPTED_202).send(updateClientType.getInitObject());
    }

}
