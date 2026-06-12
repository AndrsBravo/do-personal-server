package com.personal.management.orgstructure.delete.routes;

import com.personal.management.orgstructure.delete.process.DeleteOrgStructureProcessExecutor;
import com.personal.management.orgstructure.entities.OrgStructure;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class DeleteOrgStructureHttpHandler {

    public void Delete(ServerRequest request, ServerResponse response) {
        var id = request.path().pathParameters().get("id");

        //System.out.println("El id a eliminar " + id);
        var orgStructure = new OrgStructure(id);

        var deleteOrgStructure = DeleteOrgStructureProcessExecutor.builder()
                .init(orgStructure)
                .execute();

        switch (deleteOrgStructure.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(deleteOrgStructure.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(deleteOrgStructure.getInitObject());
        }
    }

}
