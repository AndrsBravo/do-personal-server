package com.personal.backoffice.userrelation.delete.routes;

import com.personal.backoffice.userrelation.delete.process.DeleteUserRelationProcessExecutor;
import com.personal.backoffice.userrelation.entities.UserRelation;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class DeleteUserRelationHttpHandler {

    public void Delete(ServerRequest request, ServerResponse response) {
        var id = request.path().pathParameters().get("id");

        //System.out.println("El id a eliminar " + id);
        var userRelation = new UserRelation(id);

        var deleteUserRelation = DeleteUserRelationProcessExecutor.builder()
                .init(userRelation)
                .execute();

        if (deleteUserRelation.state() == ProcessState.COMPLETED) {
            response.status(Status.OK_200).send(deleteUserRelation.getInitObject());
            return;
        }
        response.status(Status.ACCEPTED_202).send(deleteUserRelation.getInitObject());
    }

}
