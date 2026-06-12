package com.personal.business.benefit.delete.routes;

import com.personal.business.benefit.delete.process.DeleteBenefitProcessExecutor;
import com.personal.business.benefit.entities.Benefit;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class DeleteBenefitHttpHandler {

    public void Delete(ServerRequest request, ServerResponse response) {
        var id = request.path().pathParameters().get("id");

        //System.out.println("El id a eliminar " + id);
        var benefit = new Benefit(id);

        var deleteBenefit = DeleteBenefitProcessExecutor.builder()
                .init(benefit)
                .execute();

        switch (deleteBenefit.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(deleteBenefit.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(deleteBenefit.getInitObject());
        }
    }

}
