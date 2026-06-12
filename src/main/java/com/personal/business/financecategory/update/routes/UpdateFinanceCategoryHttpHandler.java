package com.personal.business.financecategory.update.routes;

import com.personal.business.financecategory.create.inputs.FinanceCategoryInput;
import com.personal.business.financecategory.update.process.UpdateFinanceCategoryProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class UpdateFinanceCategoryHttpHandler {

    public void Put(ServerRequest request, ServerResponse response) {
        var financeCategory = request.content().as(FinanceCategoryInput.class);

        var updateFinanceCategory = UpdateFinanceCategoryProcessExecutor.builder()
                .init(financeCategory.getFinanceCategory())
                .execute();

        switch (updateFinanceCategory.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(updateFinanceCategory.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(updateFinanceCategory.getInitObject());
        }
    }

}
