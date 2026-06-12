package com.personal.management.benefitdeductionrelation.delete.routes;

import com.personal.management.benefitdeductionrelation.delete.process.DeleteBenefitDeductionRelationProcessExecutor;
import com.personal.management.benefitdeductionrelation.entities.BenefitDeductionRelation;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class DeleteBenefitDeductionRelationHttpHandler {

    public void Delete(ServerRequest request, ServerResponse response) {
        var id = request.path().pathParameters().get("id");

        //System.out.println("El id a eliminar " + id);
        var benefitDeductionRelation = new BenefitDeductionRelation(id);

        var deleteBenefitDeductionRelation = DeleteBenefitDeductionRelationProcessExecutor.builder()
                .init(benefitDeductionRelation)
                .execute();

        switch (deleteBenefitDeductionRelation.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(deleteBenefitDeductionRelation.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(deleteBenefitDeductionRelation.getInitObject());
        }
    }

}
