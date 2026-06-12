package com.personal.backoffice.client.commercialplan.add.routes;

import com.personal.backoffice.client.commercialplan.add.inputs.ClientCommercialPlanInput;
import com.personal.backoffice.client.commercialplan.add.process.AddClientCommercialPlanProcessExecutor;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class AddClientCommercialPlanHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var client = request.content().as(ClientCommercialPlanInput.class);

        //System.out.println("ClientCommercialPlanInput: agregando cliente comercial plan " + client);
        var createClient = AddClientCommercialPlanProcessExecutor.builder()
                .init(client.getClient())
                .execute();
        if (createClient.state() == ProcessState.COMPLETED) {
            response.status(Status.CREATED_201).send(createClient.getInitObject());
            return;
        }
        response.status(Status.ACCEPTED_202).send(createClient.getInitObject());
    }
}
