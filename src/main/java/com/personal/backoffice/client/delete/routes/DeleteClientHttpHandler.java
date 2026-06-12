package com.personal.backoffice.client.delete.routes;

import com.personal.backoffice.client.delete.process.DeleteClientProcessExecutor;
import com.personal.backoffice.client.entities.Client;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class DeleteClientHttpHandler {

    public void Delete(ServerRequest request, ServerResponse response) {
        var id = request.path().pathParameters().get("id");

        //System.out.println("El id a eliminar " + id);
        var client = new Client(id);

        var deleteClient = DeleteClientProcessExecutor.builder()
                .init(client)
                .execute();

        if (deleteClient.state() == ProcessState.COMPLETED) {
            response.status(Status.OK_200).send(deleteClient.getInitObject());
            return;
        }
        response.status(Status.ACCEPTED_202).send(deleteClient.getInitObject());
    }

}
