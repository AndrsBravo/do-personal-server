package com.personal.management.temporalfrequency.api.routers;

import com.personal.management.temporalfrequency.create.routes.CreateTemporalFrequencyHttpHandler;
import com.personal.management.temporalfrequency.delete.routes.DeleteTemporalFrequencyHttpHandler;
import com.personal.management.temporalfrequency.filter.routes.FilterTemporalFrequencyHttpHandler;
import com.personal.management.temporalfrequency.update.routes.UpdateTemporalFrequencyHttpHandler;

import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;

public class TemporalFrequencyRouter implements HttpService {

    @Override
    public void routing(HttpRules rules) {
        rules.post("/", new CreateTemporalFrequencyHttpHandler()::Post);
        rules.put("/", new UpdateTemporalFrequencyHttpHandler()::Put);
        rules.delete("/{id}", new DeleteTemporalFrequencyHttpHandler()::Delete);
        rules.post("/filter", new FilterTemporalFrequencyHttpHandler()::Post);
    }
}
