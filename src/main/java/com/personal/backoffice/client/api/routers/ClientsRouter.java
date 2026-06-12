package com.personal.backoffice.client.api.routers;

import com.personal.backoffice.client.commercialplan.add.routes.AddClientCommercialPlanHttpHandler;
import com.personal.backoffice.client.commercialplan.filter.routes.FilterClientCommercialPlanHttpHandler;
import com.personal.backoffice.client.create.routes.CreateClientHttpHandler;
import com.personal.backoffice.client.delete.routes.DeleteClientHttpHandler;
import com.personal.backoffice.client.filter.routes.FilterClientHttpHandler;
import com.personal.backoffice.client.update.routes.UpdateClientHttpHandler;

import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;

public class ClientsRouter implements HttpService {

    @Override
    public void routing(HttpRules rules) {
        rules.post("/", new CreateClientHttpHandler()::Post);
        rules.put("/", new UpdateClientHttpHandler()::Put);
        rules.delete("/{id}", new DeleteClientHttpHandler()::Delete);
        rules.post("/filter", new FilterClientHttpHandler()::Post);
        rules.post("/plans", new AddClientCommercialPlanHttpHandler()::Post);
        rules.get("/plans/{clientid}", new FilterClientCommercialPlanHttpHandler()::Get);
    }
}
