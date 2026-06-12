package com.personal.management.orgrelation.delete.routes;

import com.personal.management.orgrelation.delete.process.DeleteOrgRelationProcessExecutor;
import com.personal.management.orgrelation.entities.OrgRelation;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class DeleteOrgRelationHttpHandler {

    public void Delete(ServerRequest request, ServerResponse response) {
        var id = request.path().pathParameters().get("id");

        //System.out.println("El id a eliminar " + id);
        var orgRelation = new OrgRelation(id);

        var deleteOrgRelation = DeleteOrgRelationProcessExecutor.builder()
                .init(orgRelation)
                .execute();

        switch (deleteOrgRelation.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(deleteOrgRelation.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(deleteOrgRelation.getInitObject());
        }
    }

}
