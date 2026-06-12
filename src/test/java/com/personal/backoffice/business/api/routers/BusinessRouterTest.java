package com.personal.backoffice.business.api.routers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.personal.backoffice.api.BaseRouterTest;

import io.helidon.http.Status;
import io.helidon.webserver.testing.junit5.DirectClient;
import jakarta.json.JsonObject;

public class BusinessRouterTest extends BaseRouterTest {

    public BusinessRouterTest(DirectClient client) {
        super(client);
    }

    @Test
    public void testFilterBusiness() {
        var input = JSON_FACTORY.createObjectBuilder()
                .add("all", "all")
                .build();

        var response = client.post("/v1/backoffice/business/filter").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(Status.OK_200, response.status());
    }

    @Test
    public void testCreateBusiness() {

        var input = JSON_FACTORY.createObjectBuilder()
                .add("clientId", "6590915e0071")
                .add("countryId", "eabc6db6ea54")
                .add("name", "Empresa de Prueba, S.R.L.")
                .build();

        var response = client.post("/v1/backoffice/business").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(Status.CREATED_201, response.status());
    }

    @Test
    public void testUpdateBusiness() {

        var input = JSON_FACTORY.createObjectBuilder()
                .add("id", "27a83226ddcf")
                .build();

        var response = client.put("/v1/backoffice/business").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(Status.OK_200, response.status());
    }

    @Test
    public void testDeleteBusiness() {

        var input = JSON_FACTORY.createObjectBuilder()
                .add("id", "ffb37e84e44f")
                .build();

        var response = client.delete("/v1/backoffice/business/" + "ffb37e84e44f").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(Status.OK_200, response.status());
    }

}
