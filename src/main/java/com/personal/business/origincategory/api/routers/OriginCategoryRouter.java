package com.personal.business.origincategory.api.routers;

import com.personal.business.origincategory.create.routes.CreateOriginCategoryHttpHandler;
import com.personal.business.origincategory.delete.routes.DeleteOriginCategoryHttpHandler;
import com.personal.business.origincategory.filter.routes.FilterOriginCategoryHttpHandler;
import com.personal.business.origincategory.update.routes.UpdateOriginCategoryHttpHandler;

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
