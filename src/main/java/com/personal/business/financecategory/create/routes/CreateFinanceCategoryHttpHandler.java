package com.personal.business.financecategory.create.routes;

import com.personal.business.financecategory.create.inputs.FinanceCategoryInput;
import com.personal.business.financecategory.create.process.CreateFinanceCategoryProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class CreateFinanceCategoryHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var financeCategory = request.content().as(FinanceCategoryInput.class);

        var createFinanceCategory = CreateFinanceCategoryProcessExecutor.builder()
                .init(financeCategory.getFinanceCategory())
                .execute();
        switch (createFinanceCategory.state()) {
            case COMPLETED ->
                response.status(Status.CREATED_201).send(createFinanceCategory.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(createFinanceCategory.getInitObject());
        }
    }
}
