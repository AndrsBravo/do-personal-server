package com.personal.management.financecategory.delete.routes;

import com.personal.management.financecategory.delete.process.DeleteFinanceCategoryProcessExecutor;
import com.personal.management.financecategory.entities.FinanceCategory;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class DeleteFinanceCategoryHttpHandler {

    public void Delete(ServerRequest request, ServerResponse response) {
        var id = request.path().pathParameters().get("id");

        //System.out.println("El id a eliminar " + id);
        var financeCategory = new FinanceCategory(id);

        var deleteFinanceCategory = DeleteFinanceCategoryProcessExecutor.builder()
                .init(financeCategory)
                .execute();

        switch (deleteFinanceCategory.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(deleteFinanceCategory.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(deleteFinanceCategory.getInitObject());
        }
    }

}
