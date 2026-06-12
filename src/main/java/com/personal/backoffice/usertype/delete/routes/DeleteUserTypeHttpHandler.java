package com.personal.backoffice.usertype.delete.routes;

import com.personal.backoffice.usertype.delete.process.DeleteUserTypeProcessExecutor;
import com.personal.shared.entities.TypeEntityBase;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class DeleteUserTypeHttpHandler {

    public void Delete(ServerRequest request, ServerResponse response) {
        var id = request.path().pathParameters().get("id");

        //System.out.println("El id a eliminar " + id);
        var userType = new TypeEntityBase(id);

        var deleteUserType = DeleteUserTypeProcessExecutor.builder()
                .init(userType)
                .execute();

        if (deleteUserType.state() == ProcessState.COMPLETED) {
            response.status(Status.OK_200).send(deleteUserType.getInitObject());
            return;
        }
        response.status(Status.ACCEPTED_202).send(deleteUserType.getInitObject());
    }

}
