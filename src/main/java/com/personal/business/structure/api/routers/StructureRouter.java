package com.personal.business.structure.api.routers;

import com.personal.business.structure.create.routes.CreateStructureHttpHandler;
import com.personal.business.structure.delete.routes.DeleteStructureHttpHandler;
import com.personal.business.structure.filter.routes.FilterStructureHttpHandler;
import com.personal.business.structure.update.routes.UpdateStructureHttpHandler;

import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;

public class StructureRouter implements HttpService {

    @Override
    public void routing(HttpRules rules) {
        rules.post("/", new CreateStructureHttpHandler()::Post);
        rules.put("/", new UpdateStructureHttpHandler()::Put);
        rules.delete("/{id}", new DeleteStructureHttpHandler()::Delete);
        rules.post("/filter", new FilterStructureHttpHandler()::Post);
    }
}
