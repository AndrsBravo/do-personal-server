package com.personal.backoffice.country.api.routers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.personal.backoffice.api.BaseRouterTest;

import io.helidon.http.Status;
import io.helidon.webserver.testing.junit5.DirectClient;
import jakarta.json.JsonObject;

public class CountryRouterTest extends BaseRouterTest {

    public CountryRouterTest(DirectClient client) {
        super(client);
    }

    @Test
    public void testFilterCountries() {
        var input = JSON_FACTORY.createObjectBuilder()
                .add("all", "all")
                .build();

        var response = client.post("/v1/backoffice/countries/filter").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(response.status(), Status.OK_200);
    }

    @Test
    public void testCreateCountries() {

        var input = JSON_FACTORY.createObjectBuilder()
                .add("code", "RD")
                .add("name", "Republica Dominicana")
                .build();

        var response = client.post("/v1/backoffice/countries").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(response.status(), Status.CREATED_201);
    }

    @Test
    public void testUpdateCountries() {

        var input = JSON_FACTORY.createObjectBuilder()
                .add("id", "dc60f986")
                .add("description", "Country Updated")
                .build();

        var response = client.put("/v1/backoffice/countries").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(response.status(), Status.OK_200);
    }

    @Test
    public void testDeleteCountries() {

        var input = JSON_FACTORY.createObjectBuilder()
                .add("id", "dc60f986")
                .build();

        var response = client.delete("/v1/backoffice/countries/" + "dc60f986").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(response.status(), Status.OK_200);
    }

}
