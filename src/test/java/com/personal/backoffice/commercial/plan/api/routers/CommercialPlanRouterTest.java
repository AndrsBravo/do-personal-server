package com.personal.backoffice.commercial.plan.api.routers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.personal.shared.api.BaseRouterTest;

import io.helidon.http.Status;
import io.helidon.webserver.testing.junit5.DirectClient;
import jakarta.json.JsonObject;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CommercialPlanRouterTest extends BaseRouterTest {

    public CommercialPlanRouterTest(DirectClient client) {
        super(client);
    }

    @Test
    public void testFilterCommercialPlan() {
        var input = JSON_FACTORY.createObjectBuilder()
                .add("all", "all")
                .build();

        var response = client.post("/v1/backoffice/commercial_plan/filter").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(response.status(), Status.OK_200);
    }

    @Test
    public void testCreateCommercialPlan() {

        var input = JSON_FACTORY.createObjectBuilder()
                .add("plan", "demo")
                .add("title", "Demo")
                .add("description", "Plan de prueba para para clientes")
                .build();

        var response = client.post("/v1/backoffice/commercial_plan").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(response.status(), Status.CREATED_201);
    }

    @Test
    public void testUpdateCommercialPlan() {

        var input = JSON_FACTORY.createObjectBuilder()
                .add("id", "82b38b34")
                .add("description", "Este plan es un trial para clientes")
                .build();

        var response = client.put("/v1/backoffice/commercial_plan").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(response.status(), Status.OK_200);
    }

    @Test
    public void testDeleteCommercialPlan() {

        var input = JSON_FACTORY.createObjectBuilder()
                .add("id", "82b38b34")
                .build();

        var response = client.delete("/v1/backoffice/commercial_plan/" + "82b38b34").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(response.status(), Status.OK_200);
    }

}
