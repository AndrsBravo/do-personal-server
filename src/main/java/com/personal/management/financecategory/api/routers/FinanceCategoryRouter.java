package com.personal.management.financecategory.api.routers;

import com.personal.management.financecategory.create.routes.CreateFinanceCategoryHttpHandler;
import com.personal.management.financecategory.delete.routes.DeleteFinanceCategoryHttpHandler;
import com.personal.management.financecategory.filter.routes.FilterFinanceCategoryHttpHandler;
import com.personal.management.financecategory.update.routes.UpdateFinanceCategoryHttpHandler;

import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;

public class FinanceCategoryRouter implements HttpService {

    @Override
    public void routing(HttpRules rules) {
        rules.post("/", new CreateFinanceCategoryHttpHandler()::Post);
        rules.put("/", new UpdateFinanceCategoryHttpHandler()::Put);
        rules.delete("/{id}", new DeleteFinanceCategoryHttpHandler()::Delete);
        rules.post("/filter", new FilterFinanceCategoryHttpHandler()::Post);
    }
}
