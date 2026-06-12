package com.personal.business.structure.delete.routes;

import com.personal.business.structure.delete.process.DeleteStructureProcessExecutor;
import com.personal.business.structure.entities.Structure;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class DeleteStructureHttpHandler {

    public void Delete(ServerRequest request, ServerResponse response) {
        var id = request.path().pathParameters().get("id");

        //System.out.println("El id a eliminar " + id);
        var structure = new Structure(id);

        var deleteStructure = DeleteStructureProcessExecutor.builder()
                .init(structure)
                .execute();

        switch (deleteStructure.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(deleteStructure.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(deleteStructure.getInitObject());
        }
    }

}
