package com.personal.backoffice.commercial.plandetail.delete.routes;

import com.personal.backoffice.commercial.plandetail.delete.process.DeleteCommercialPlanDetailProcessExecutor;
import com.personal.backoffice.commercial.plandetail.entities.CommercialPlanDetail;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class DeleteCommercialPlanDetailHttpHandler {

    public void Delete(ServerRequest request, ServerResponse response) {
        var id = request.path().pathParameters().get("id");

        //System.out.println("El id a eliminar " + id);
        var commercialPlan = new CommercialPlanDetail(id);

        var deleteCommercialPlanDetail = DeleteCommercialPlanDetailProcessExecutor.builder()
                .init(commercialPlan)
                .execute();

        if (deleteCommercialPlanDetail.state() == ProcessState.COMPLETED) {
            response.status(Status.OK_200).send(deleteCommercialPlanDetail.getInitObject());
            return;
        }
        response.status(Status.ACCEPTED_202).send(deleteCommercialPlanDetail.getInitObject());
    }

}
