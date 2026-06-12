package com.personal.backoffice.commercial.entity.api.routers;

import com.personal.backoffice.commercial.entity.create.routes.CreateCommercialEntityHttpHandler;
import com.personal.backoffice.commercial.entity.delete.routes.DeleteCommercialEntityHttpHandler;
import com.personal.backoffice.commercial.entity.filter.routes.FilterCommercialEntityHttpHandler;
import com.personal.backoffice.commercial.entity.update.routes.UpdateCommercialEntityHttpHandler;

import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;

public class CommercialEntityRouter implements HttpService {

    @Override
    public void routing(HttpRules rules) {
        rules.post("/", new CreateCommercialEntityHttpHandler()::Post);
        rules.put("/", new UpdateCommercialEntityHttpHandler()::Put);
        rules.delete("/{id}", new DeleteCommercialEntityHttpHandler()::Delete);
        rules.post("/filter", new FilterCommercialEntityHttpHandler()::Post);
    }
}
