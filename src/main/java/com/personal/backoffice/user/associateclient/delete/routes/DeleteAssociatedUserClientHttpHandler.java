package com.personal.backoffice.user.associateclient.delete.routes;

import com.personal.backoffice.user.associateclient.add.inputs.AssociateUserClientInput;
import com.personal.backoffice.user.associateclient.delete.process.DeleteAssociatedUserClientProcessExecutor;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class DeleteAssociatedUserClientHttpHandler {

    public void Delete(ServerRequest request, ServerResponse response) {
        var associatedUserClientInput = request.content().as(AssociateUserClientInput.class);

        var deleteClient = DeleteAssociatedUserClientProcessExecutor.builder()
                .init(associatedUserClientInput.toAssociateUserClient())
                .execute();

        switch (deleteClient.state()) {
            case ProcessState.COMPLETED ->
                response.status(Status.OK_200).send(deleteClient.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(deleteClient.getInitObject());
        }
    }

}
