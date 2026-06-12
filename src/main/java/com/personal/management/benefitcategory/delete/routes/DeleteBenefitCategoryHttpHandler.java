package com.personal.management.benefitcategory.delete.routes;

import com.personal.management.benefitcategory.delete.process.DeleteBenefitCategoryProcessExecutor;
import com.personal.management.benefitcategory.entities.BenefitCategory;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class DeleteBenefitCategoryHttpHandler {

    public void Delete(ServerRequest request, ServerResponse response) {
        var id = request.path().pathParameters().get("id");

        //System.out.println("El id a eliminar " + id);
        var benefitCategory = new BenefitCategory(id);

        var deleteBenefitCategory = DeleteBenefitCategoryProcessExecutor.builder()
                .init(benefitCategory)
                .execute();

        switch (deleteBenefitCategory.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(deleteBenefitCategory.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(deleteBenefitCategory.getInitObject());
        }
    }

}
