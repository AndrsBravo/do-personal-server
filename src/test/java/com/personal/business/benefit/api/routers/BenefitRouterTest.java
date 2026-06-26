package com.personal.business.benefit.api.routers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.personal.shared.api.BaseRouterTest;

import io.helidon.http.Status;
import io.helidon.webserver.testing.junit5.DirectClient;
import jakarta.json.JsonObject;

public class BenefitRouterTest extends BaseRouterTest {

    public BenefitRouterTest(DirectClient client) {
        super(client);
    }

    @Test
    public void testFilterBenefits() {
        var input = JSON_FACTORY.createObjectBuilder()
                .add("all", "all")
                .build();

        var response = client.post("/v1/business/benefits/filter").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(response.status(), Status.OK_200);
    }

    @Test
    public void testCreateBenefits() {

        var input = JSON_FACTORY.createObjectBuilder()
                .add("clientTypeId", "3c86df88")
                .add("countryId", "41b6ee30")
                .build();

        var response = client.post("/v1/business/benefits").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(Status.CREATED_201, response.status());
    }

    @Test
    public void testUpdateBenefits() {

        var input = JSON_FACTORY.createObjectBuilder()
                .add("id", "dc60f986")
                .add("description", "Client type Updated")
                .build();

        var response = client.put("/v1/business/benefits").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(response.status(), Status.OK_200);
    }

    @Test
    public void testDeleteBenefits() {

        var input = JSON_FACTORY.createObjectBuilder()
                .add("id", "dc60f986")
                .build();

        var response = client.delete("/v1/business/benefits/" + "dc60f986").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(response.status(), Status.OK_200);
    }
}
