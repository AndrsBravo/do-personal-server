package com.personal.backoffice.clienttype.api.routers;

import com.personal.backoffice.clienttype.create.routes.CreateClientTypeHttpHandler;
import com.personal.backoffice.clienttype.delete.routes.DeleteClientTypeHttpHandler;
import com.personal.backoffice.clienttype.filter.routes.FilterClientTypeHttpHandler;
import com.personal.backoffice.clienttype.update.routes.UpdateClientTypeHttpHandler;

import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;

public class ClientTypesRouter implements HttpService {

    @Override
    public void routing(HttpRules rules) {
        rules.post("/", new CreateClientTypeHttpHandler()::Post);
        rules.put("/", new UpdateClientTypeHttpHandler()::Put);
        rules.delete("/{id}", new DeleteClientTypeHttpHandler()::Delete);
        rules.post("/filter", new FilterClientTypeHttpHandler()::Post);
    }
}
