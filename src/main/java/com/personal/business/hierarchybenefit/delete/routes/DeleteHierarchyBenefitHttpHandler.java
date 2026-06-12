package com.personal.business.hierarchybenefit.delete.routes;

import com.personal.business.hierarchybenefit.delete.process.DeleteHierarchyBenefitProcessExecutor;
import com.personal.business.hierarchybenefit.entities.HierarchyBenefit;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class DeleteHierarchyBenefitHttpHandler {

    public void Delete(ServerRequest request, ServerResponse response) {
        var id = request.path().pathParameters().get("id");

        //System.out.println("El id a eliminar " + id);
        var hierarchyBenefit = new HierarchyBenefit(id);

        var deleteHierarchyBenefit = DeleteHierarchyBenefitProcessExecutor.builder()
                .init(hierarchyBenefit)
                .execute();

        switch (deleteHierarchyBenefit.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(deleteHierarchyBenefit.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(deleteHierarchyBenefit.getInitObject());
        }
    }

}
