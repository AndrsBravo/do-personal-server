package com.personal.business.hierarchy.delete.routes;

import com.personal.business.hierarchy.delete.process.DeleteHierarchyProcessExecutor;
import com.personal.business.hierarchy.entities.Hierarchy;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class DeleteHierarchyHttpHandler {

    public void Delete(ServerRequest request, ServerResponse response) {
        var id = request.path().pathParameters().get("id");

        //System.out.println("El id a eliminar " + id);
        var hierarchy = new Hierarchy(id);

        var deleteHierarchy = DeleteHierarchyProcessExecutor.builder()
                .init(hierarchy)
                .execute();

        switch (deleteHierarchy.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(deleteHierarchy.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(deleteHierarchy.getInitObject());
        }
    }

}
