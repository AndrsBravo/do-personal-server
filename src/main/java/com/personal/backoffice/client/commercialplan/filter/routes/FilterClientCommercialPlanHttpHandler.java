package com.personal.backoffice.client.commercialplan.filter.routes;

import com.personal.backoffice.client.commercialplan.filter.inputs.FilterClientCommercialPlanInput;
import com.personal.backoffice.client.commercialplan.filter.process.FilterClientCommercialPlanProcessExecutor;
import com.personal.shared.http.Response;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class FilterClientCommercialPlanHttpHandler {

    public void Get(ServerRequest request, ServerResponse response) {

        var clientId = request.path().pathParameters().get("clientid");

        var clientCommercialPlan = new FilterClientCommercialPlanInput();
        clientCommercialPlan.setClientId(clientId);

        var clientProcess = FilterClientCommercialPlanProcessExecutor.builder()
                .init(clientCommercialPlan)
                .execute();

        if (clientProcess.state() == ProcessState.STOP_WITH_ERROR) {
            response.status(Status.NO_CONTENT_204).send(Response.error("204", clientProcess.getCurrentLog()));
            return;
        }
        response.status(Status.OK_200).send(Response.success(clientProcess.getResult()));

    }
}
