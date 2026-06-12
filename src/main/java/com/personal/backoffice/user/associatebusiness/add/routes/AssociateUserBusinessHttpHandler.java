package com.personal.backoffice.user.associatebusiness.add.routes;

import com.personal.backoffice.user.associatebusiness.add.inputs.AssociateUserBusinessInput;
import com.personal.backoffice.user.associatebusiness.add.process.AssociateUserBusinessProcessExecutor;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class AssociateUserBusinessHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {

        var associateUserBusiness = request.content().as(AssociateUserBusinessInput.class);

        //System.out.println("AssociateUserBusiness: " + associateUserBusiness);
        var createClient = AssociateUserBusinessProcessExecutor.builder()
                .init(associateUserBusiness.toAssociateUserBusiness())
                .execute();
        if (createClient.state() == ProcessState.COMPLETED) {
            response.status(Status.CREATED_201).send(createClient.getInitObject());
            return;
        }
        response.status(Status.ACCEPTED_202).send(createClient.getInitObject());
    }
}
