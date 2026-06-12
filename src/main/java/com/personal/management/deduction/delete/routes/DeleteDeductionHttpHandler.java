package com.personal.management.deduction.delete.routes;

import com.personal.management.deduction.delete.process.DeleteDeductionProcessExecutor;
import com.personal.management.deduction.entities.Deduction;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class DeleteDeductionHttpHandler {

    public void Delete(ServerRequest request, ServerResponse response) {
        var id = request.path().pathParameters().get("id");

        //System.out.println("El id a eliminar " + id);
        var deduction = new Deduction(id);

        var deleteDeduction = DeleteDeductionProcessExecutor.builder()
                .init(deduction)
                .execute();

        switch (deleteDeduction.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(deleteDeduction.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(deleteDeduction.getInitObject());
        }
    }

}
