package com.personal.business.benefitrate.delete.routes;

import com.personal.business.benefitrate.delete.process.DeleteBenefitRateProcessExecutor;
import com.personal.business.benefitrate.entities.BenefitRate;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class DeleteBenefitRateHttpHandler {

    public void Delete(ServerRequest request, ServerResponse response) {
        var id = request.path().pathParameters().get("id");

        //System.out.println("El id a eliminar " + id);
        var benefitRate = new BenefitRate(id);

        var deleteBenefitRate = DeleteBenefitRateProcessExecutor.builder()
                .init(benefitRate)
                .execute();

        switch (deleteBenefitRate.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(deleteBenefitRate.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(deleteBenefitRate.getInitObject());
        }
    }

}
