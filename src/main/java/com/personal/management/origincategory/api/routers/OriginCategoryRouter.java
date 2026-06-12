package com.personal.management.origincategory.api.routers;

import com.personal.management.origincategory.create.routes.CreateOriginCategoryHttpHandler;
import com.personal.management.origincategory.delete.routes.DeleteOriginCategoryHttpHandler;
import com.personal.management.origincategory.filter.routes.FilterOriginCategoryHttpHandler;
import com.personal.management.origincategory.update.routes.UpdateOriginCategoryHttpHandler;

import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;

public class OriginCategoryRouter implements HttpService {

    @Override
    public void routing(HttpRules rules) {
        rules.post("/", new CreateOriginCategoryHttpHandler()::Post);
        rules.put("/", new UpdateOriginCategoryHttpHandler()::Put);
        rules.delete("/{id}", new DeleteOriginCategoryHttpHandler()::Delete);
        rules.post("/filter", new FilterOriginCategoryHttpHandler()::Post);
    }
}
