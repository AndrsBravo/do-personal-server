package com.personal.business.temporalfrequency.api.routers;

import com.personal.business.temporalfrequency.create.routes.CreateTemporalFrequencyHttpHandler;
import com.personal.business.temporalfrequency.delete.routes.DeleteTemporalFrequencyHttpHandler;
import com.personal.business.temporalfrequency.filter.routes.FilterTemporalFrequencyHttpHandler;
import com.personal.business.temporalfrequency.update.routes.UpdateTemporalFrequencyHttpHandler;

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
