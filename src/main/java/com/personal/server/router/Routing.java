package com.personal.server.router;

import com.personal.backoffice.api.BackOfficeRouter;
import com.personal.business.api.ApplicationRouter;
import com.personal.management.api.ManagementRouting;

import io.helidon.webserver.http.HttpRouting;

public class Routing {

    public static void routing(HttpRouting.Builder routing) {

        routing
                .register("/v1/app", ApplicationRouter::new)
                .register("/v1/backoffice", BackOfficeRouter::new)
                .register("/v1/management", ManagementRouting::new);
    }

}
