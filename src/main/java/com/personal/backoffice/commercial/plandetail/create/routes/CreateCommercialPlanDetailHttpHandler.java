package com.personal.backoffice.commercial.plandetail.create.routes;

import com.personal.backoffice.commercial.plandetail.create.inputs.CommercialPlanDetailInput;
import com.personal.backoffice.commercial.plandetail.create.process.CreateCommercialPlanDetailProcessExecutor;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class CreateCommercialPlanDetailHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var commercialPlan = request.content().as(CommercialPlanDetailInput.class);

        var createCommercialPlanDetail = CreateCommercialPlanDetailProcessExecutor.builder()
                .init(commercialPlan.getCommercialPlanDetail())
                .execute();
        if (createCommercialPlanDetail.state() == ProcessState.COMPLETED) {
            response.status(Status.CREATED_201).send(createCommercialPlanDetail.getInitObject());
            return;
        }
        response.status(Status.ACCEPTED_202).send(createCommercialPlanDetail.getInitObject());
    }
}
