package com.personal.backoffice.commercial.entity.delete.routes;

import com.personal.backoffice.commercial.entity.delete.process.DeleteCommercialEntityProcessExecutor;
import com.personal.backoffice.commercial.entity.entities.CommercialEntity;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class DeleteCommercialEntityHttpHandler {

    public void Delete(ServerRequest request, ServerResponse response) {
        var id = request.path().pathParameters().get("id");

        //System.out.println("El id a eliminar " + id);
        var commercialEntity = new CommercialEntity(id);

        var deleteCommercialEntity = DeleteCommercialEntityProcessExecutor.builder()
                .init(commercialEntity)
                .execute();

        if (deleteCommercialEntity.state() == ProcessState.COMPLETED) {
            response.status(Status.OK_200).send(deleteCommercialEntity.getInitObject());
            return;
        }
        response.status(Status.ACCEPTED_202).send(deleteCommercialEntity.getInitObject());
    }

}
