package com.personal.backoffice.userrole.delete.routes;

import com.personal.backoffice.userrole.delete.process.DeleteUserRoleProcessExecutor;
import com.personal.backoffice.userrole.entities.UserRole;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class DeleteUserRoleHttpHandler {

    public void Delete(ServerRequest request, ServerResponse response) {
        var id = request.path().pathParameters().get("id");

        //System.out.println("El id a eliminar " + id);
        var userRole = new UserRole(id);

        var deleteUserRole = DeleteUserRoleProcessExecutor.builder()
                .init(userRole)
                .execute();

        if (deleteUserRole.state() == ProcessState.COMPLETED) {
            response.status(Status.OK_200).send(deleteUserRole.getInitObject());
            return;
        }
        response.status(Status.ACCEPTED_202).send(deleteUserRole.getInitObject());
    }

}
