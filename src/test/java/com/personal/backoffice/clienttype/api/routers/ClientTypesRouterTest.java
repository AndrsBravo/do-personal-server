package com.personal.backoffice.clienttype.api.routers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.personal.backoffice.api.BaseRouterTest;

import io.helidon.http.Status;
import io.helidon.webserver.testing.junit5.DirectClient;
import jakarta.json.JsonObject;

public class ClientTypesRouterTest extends BaseRouterTest {

    public ClientTypesRouterTest(DirectClient client) {
        super(client);
    }

    @Test
    public void testFilterClientTypes() {
        var input = JSON_FACTORY.createObjectBuilder()
                .add("all", "all")
                .build();

        var response = client.post("/v1/backoffice/client_types/filter").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(response.status(), Status.OK_200);
    }

    @Test
    public void testCreateClientTypes() {

        var input = JSON_FACTORY.createObjectBuilder()
                .add("type", "test_type")
                .add("title", "Test type of client")
                .add("description", "New Client type for testing purposes")
                .build();

        var response = client.post("/v1/backoffice/client_types").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(response.status(), Status.CREATED_201);
    }

    @Test
    public void testUpdateClientTypes() {

        var input = JSON_FACTORY.createObjectBuilder()
                .add("id", "dc60f986")
                .add("description", "Client type Updated")
                .build();

        var response = client.put("/v1/backoffice/client_types").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(response.status(), Status.OK_200);
    }

    @Test
    public void testDeleteClientTypes() {

        var input = JSON_FACTORY.createObjectBuilder()
                .add("id", "dc60f986")
                .build();

        var response = client.delete("/v1/backoffice/client_types/" + "dc60f986").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(response.status(), Status.OK_200);
    }

}
