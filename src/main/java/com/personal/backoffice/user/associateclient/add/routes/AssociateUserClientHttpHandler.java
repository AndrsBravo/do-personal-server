package com.personal.backoffice.user.associateclient.add.routes;

import com.personal.backoffice.user.associateclient.add.inputs.AssociateUserClientInput;
import com.personal.backoffice.user.associateclient.add.process.AssociateUserClientProcessExecutor;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class AssociateUserClientHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {

        var associateUserClient = request.content().as(AssociateUserClientInput.class);

        //System.out.println("AssociateUserClient: " + associateUserClient);
        var createClient = AssociateUserClientProcessExecutor.builder()
                .init(associateUserClient.toAssociateUserClient())
                .execute();
        if (createClient.state() == ProcessState.COMPLETED) {
            response.status(Status.CREATED_201).send(createClient.getInitObject());
            return;
        }
        response.status(Status.ACCEPTED_202).send(createClient.getInitObject());
    }
}
