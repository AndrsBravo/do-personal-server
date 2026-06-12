package com.personal.backoffice.commercial.plan.update.routes;

import com.personal.backoffice.commercial.plan.create.inputs.CommercialPlanInput;
import com.personal.backoffice.commercial.plan.update.process.UpdateCommercialPlanProcessExecutor;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class UpdateCommercialPlanHttpHandler {

    public void Put(ServerRequest request, ServerResponse response) {
        var commercialPlan = request.content().as(CommercialPlanInput.class);

        var updateCommercialPlan = UpdateCommercialPlanProcessExecutor.builder()
                .init(commercialPlan.getCommercialPlan())
                .execute();

        if (updateCommercialPlan.state() == ProcessState.COMPLETED) {
            response.status(Status.OK_200).send(updateCommercialPlan.getInitObject());
            return;
        }
        response.status(Status.ACCEPTED_202).send(updateCommercialPlan.getInitObject());
    }

}
