package com.personal.backoffice.commercial.plandetail.update.routes;

import com.personal.backoffice.commercial.plandetail.create.inputs.CommercialPlanDetailInput;
import com.personal.backoffice.commercial.plandetail.update.process.UpdateCommercialPlanDetailProcessExecutor;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class UpdateCommercialPlanDetailHttpHandler {

    public void Put(ServerRequest request, ServerResponse response) {
        var commercialPlan = request.content().as(CommercialPlanDetailInput.class);

        var updateCommercialPlanDetail = UpdateCommercialPlanDetailProcessExecutor.builder()
                .init(commercialPlan.getCommercialPlanDetail())
                .execute();

        if (updateCommercialPlanDetail.state() == ProcessState.COMPLETED) {
            response.status(Status.OK_200).send(updateCommercialPlanDetail.getInitObject());
            return;
        }
        response.status(Status.ACCEPTED_202).send(updateCommercialPlanDetail.getInitObject());
    }

}
