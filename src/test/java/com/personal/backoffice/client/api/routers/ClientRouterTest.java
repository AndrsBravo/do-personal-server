package com.personal.backoffice.client.api.routers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.personal.backoffice.api.BaseRouterTest;

import io.helidon.http.Status;
import io.helidon.webserver.testing.junit5.DirectClient;
import jakarta.json.JsonObject;

public class ClientRouterTest extends BaseRouterTest {

    public ClientRouterTest(DirectClient client) {
        super(client);
    }

    @Test
    public void testFilterClients() {
        var input = JSON_FACTORY.createObjectBuilder()
                .add("all", "all")
                .build();

        var response = client.post("/v1/backoffice/clients/filter").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(response.status(), Status.OK_200);
    }

    @Test
    public void testCreateClients() {

        var input = JSON_FACTORY.createObjectBuilder()
                .add("clientTypeId", "506e666c")
                .add("countryId", "eabc6db6ea54")
                .build();

        var response = client.post("/v1/backoffice/clients").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(Status.CREATED_201, response.status());
    }

    @Test
    public void testUpdateClients() {

        var input = JSON_FACTORY.createObjectBuilder()
                .add("id", "dc60f986")
                .add("description", "Client type Updated")
                .build();

        var response = client.put("/v1/backoffice/clients").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(response.status(), Status.OK_200);
    }

    @Test
    public void testDeleteClients() {

        var input = JSON_FACTORY.createObjectBuilder()
                .add("id", "dc60f986")
                .build();

        var response = client.delete("/v1/backoffice/clients/" + "dc60f986").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(response.status(), Status.OK_200);
    }

    @Test
    public void testAddClientCommercialPlan() {

        var input = JSON_FACTORY.createObjectBuilder()
                .add("clientId", "92ac76d6c093")
                .add("commercialPlanId", "82b38b34")
                .build();

        var response = client.post("/v1/backoffice/clients/plans").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(Status.ACCEPTED_202, response.status());
    }

    @Test
    public void testGetClientCommercialPlan() {

        var response = client.get("/v1/backoffice/clients/plans/92ac76d6c093").request(JsonObject.class);
        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(Status.OK_200, response.status());
    }
}
