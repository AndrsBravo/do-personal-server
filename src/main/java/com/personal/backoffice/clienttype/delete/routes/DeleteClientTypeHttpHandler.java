package com.personal.backoffice.clienttype.delete.routes;

import com.personal.backoffice.clienttype.delete.process.DeleteClientTypeProcessExecutor;
import com.personal.shared.entities.TypeEntityBase;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class DeleteClientTypeHttpHandler {

    public void Delete(ServerRequest request, ServerResponse response) {
        var id = request.path().pathParameters().get("id");

        //System.out.println("El id a eliminar " + id);
        var clientType = new TypeEntityBase(id);

        var deleteClientType = DeleteClientTypeProcessExecutor.builder()
                .init(clientType)
                .execute();

        if (deleteClientType.state() == ProcessState.COMPLETED) {
            response.status(Status.OK_200).send(deleteClientType.getInitObject());
            return;
        }
        response.status(Status.ACCEPTED_202).send(deleteClientType.getInitObject());
    }

}
