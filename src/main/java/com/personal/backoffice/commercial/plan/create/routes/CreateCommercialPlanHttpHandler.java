package com.personal.backoffice.commercial.plan.create.routes;

import com.personal.backoffice.commercial.plan.create.inputs.CommercialPlanInput;
import com.personal.backoffice.commercial.plan.create.process.CreateCommercialPlanProcessExecutor;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class CreateCommercialPlanHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var commercialPlan = request.content().as(CommercialPlanInput.class);

        var createCommercialPlan = CreateCommercialPlanProcessExecutor.builder()
                .init(commercialPlan.getCommercialPlan())
                .execute();
        if (createCommercialPlan.state() == ProcessState.COMPLETED) {
            response.status(Status.CREATED_201).send(createCommercialPlan.getInitObject());
            return;
        }
        response.status(Status.ACCEPTED_202).send(createCommercialPlan.getInitObject());
    }
}
