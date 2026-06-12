package com.personal.backoffice.commercial.plan.delete.routes;

import com.personal.backoffice.commercial.plan.delete.process.DeleteCommercialPlanProcessExecutor;
import com.personal.backoffice.commercial.plan.entities.CommercialPlan;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class DeleteCommercialPlanHttpHandler {

    public void Delete(ServerRequest request, ServerResponse response) {
        var id = request.path().pathParameters().get("id");

        //System.out.println("El id a eliminar " + id);
        var commercialPlan = new CommercialPlan(id);

        var deleteCommercialPlan = DeleteCommercialPlanProcessExecutor.builder()
                .init(commercialPlan)
                .execute();

        if (deleteCommercialPlan.state() == ProcessState.COMPLETED) {
            response.status(Status.OK_200).send(deleteCommercialPlan.getInitObject());
            return;
        }
        response.status(Status.ACCEPTED_202).send(deleteCommercialPlan.getInitObject());
    }

}
