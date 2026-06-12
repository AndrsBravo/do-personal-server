package com.personal.backoffice.business.api.routes;

import com.personal.backoffice.business.entities.Business;
import com.personal.backoffice.business.process.delete.DeleteBusinessProcessExecutor;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class DeleteBusinessHttpHandler {

    public void Delete(ServerRequest request, ServerResponse response) {
        var id = request.path().pathParameters().get("id");

        //System.out.println("El id a eliminar " + id);
        var business = new Business(id);

        var deleteBusiness = DeleteBusinessProcessExecutor.builder()
                .init(business)
                .execute();

        if (deleteBusiness.state() == ProcessState.COMPLETED) {
            response.status(Status.OK_200).send(deleteBusiness.getInitObject());
            return;
        }
        response.status(Status.ACCEPTED_202).send(deleteBusiness.getInitObject());
    }

}
