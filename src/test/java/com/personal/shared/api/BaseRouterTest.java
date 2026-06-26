package com.personal.shared.api;

import java.util.Map;

import com.personal.server.router.Routing;

import io.helidon.webclient.http1.Http1Client;
import io.helidon.webserver.http.HttpRouting;
import io.helidon.webserver.testing.junit5.DirectClient;
import io.helidon.webserver.testing.junit5.RoutingTest;
import io.helidon.webserver.testing.junit5.SetUpRoute;
import jakarta.json.Json;
import jakarta.json.JsonBuilderFactory;

@RoutingTest
public abstract class BaseRouterTest {

    protected Http1Client client;

    protected final JsonBuilderFactory JSON_FACTORY = Json.createBuilderFactory(Map.of());

    public BaseRouterTest(DirectClient client) {
        this.client = client;
    }

    @SetUpRoute
    static void routing(HttpRouting.Builder builder) {
        Routing.routing(builder);
    }

}
