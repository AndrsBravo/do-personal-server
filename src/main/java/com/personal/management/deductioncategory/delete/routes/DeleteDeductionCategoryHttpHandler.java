package com.personal.management.deductioncategory.delete.routes;

import com.personal.management.deductioncategory.delete.process.DeleteDeductionCategoryProcessExecutor;
import com.personal.management.deductioncategory.entities.DeductionCategory;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class DeleteDeductionCategoryHttpHandler {

    public void Delete(ServerRequest request, ServerResponse response) {
        var id = request.path().pathParameters().get("id");

        //System.out.println("El id a eliminar " + id);
        var deductionCategory = new DeductionCategory(id);

        var deleteDeductionCategory = DeleteDeductionCategoryProcessExecutor.builder()
                .init(deductionCategory)
                .execute();

        switch (deleteDeductionCategory.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(deleteDeductionCategory.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(deleteDeductionCategory.getInitObject());
        }
    }

}
