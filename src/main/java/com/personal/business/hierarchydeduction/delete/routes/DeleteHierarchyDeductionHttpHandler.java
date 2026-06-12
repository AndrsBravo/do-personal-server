package com.personal.business.hierarchydeduction.delete.routes;

import com.personal.business.hierarchydeduction.delete.process.DeleteHierarchyDeductionProcessExecutor;
import com.personal.business.hierarchydeduction.entities.HierarchyDeduction;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class DeleteHierarchyDeductionHttpHandler {

    public void Delete(ServerRequest request, ServerResponse response) {
        var id = request.path().pathParameters().get("id");

        //System.out.println("El id a eliminar " + id);
        var hierarchyDeduction = new HierarchyDeduction(id);

        var deleteHierarchyDeduction = DeleteHierarchyDeductionProcessExecutor.builder()
                .init(hierarchyDeduction)
                .execute();

        switch (deleteHierarchyDeduction.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(deleteHierarchyDeduction.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(deleteHierarchyDeduction.getInitObject());
        }
    }

}
