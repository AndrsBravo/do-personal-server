package com.personal.backoffice.country.api.routers;

import com.personal.backoffice.country.create.routes.CreateCountryHttpHandler;
import com.personal.backoffice.country.delete.routes.DeleteCountryHttpHandler;
import com.personal.backoffice.country.filter.routes.FilterCountryHttpHandler;
import com.personal.backoffice.country.update.routes.UpdateCountryHttpHandler;

import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;

public class CountryRouter implements HttpService {

    @Override
    public void routing(HttpRules rules) {
        rules.post("/", new CreateCountryHttpHandler()::Post);
        rules.put("/", new UpdateCountryHttpHandler()::Put);
        rules.delete("/{id}", new DeleteCountryHttpHandler()::Delete);
        rules.post("/filter", new FilterCountryHttpHandler()::Post);
    }
}
