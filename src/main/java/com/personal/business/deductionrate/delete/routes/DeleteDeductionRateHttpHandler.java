package com.personal.business.deductionrate.delete.routes;

import com.personal.business.deductionrate.delete.process.DeleteDeductionRateProcessExecutor;
import com.personal.business.deductionrate.entities.DeductionRate;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class DeleteDeductionRateHttpHandler {

    public void Delete(ServerRequest request, ServerResponse response) {
        var id = request.path().pathParameters().get("id");

        //System.out.println("El id a eliminar " + id);
        var deductionRate = new DeductionRate(id);

        var deleteDeductionRate = DeleteDeductionRateProcessExecutor.builder()
                .init(deductionRate)
                .execute();

        switch (deleteDeductionRate.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(deleteDeductionRate.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(deleteDeductionRate.getInitObject());
        }
    }

}
