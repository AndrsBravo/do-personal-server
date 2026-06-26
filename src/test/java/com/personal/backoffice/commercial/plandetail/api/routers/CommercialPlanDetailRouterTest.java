package com.personal.backoffice.commercial.plandetail.api.routers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.personal.shared.api.BaseRouterTest;

import io.helidon.http.Status;
import io.helidon.webserver.testing.junit5.DirectClient;
import jakarta.json.JsonObject;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CommercialPlanDetailRouterTest extends BaseRouterTest {

    public CommercialPlanDetailRouterTest(DirectClient client) {
        super(client);
    }

    @Test
    public void testFilterCommercialPlanDetail() {
        var input = JSON_FACTORY.createObjectBuilder()
                .add("all", "all")
                .build();

        var response = client.post("/v1/backoffice/commercial_plan_detail/filter").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(response.status(), Status.OK_200);
    }

    @Test
    public void testCreateCommercialPlanDetail() {

        var input = JSON_FACTORY.createObjectBuilder()
                .add("planId", "82b38b34")
                .add("entityId", "708e4710")
                .add("quantity", 1)
                .build();

        var response = client.post("/v1/backoffice/commercial_plan_detail").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(response.status(), Status.CREATED_201);
    }

    @Test
    public void testUpdateCommercialPlanDetail() {

        var input = JSON_FACTORY.createObjectBuilder()
                .add("id", "82b38b34")
                .add("description", "Este plan es un trial para clientes")
                .build();

        var response = client.put("/v1/backoffice/commercial_plan_detail").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(response.status(), Status.OK_200);
    }

    @Test
    public void testDeleteCommercialPlanDetail() {

        var input = JSON_FACTORY.createObjectBuilder()
                .add("id", "82b38b34")
                .build();

        var response = client.delete("/v1/backoffice/commercial_plan_detail/" + "82b38b34").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(response.status(), Status.OK_200);
    }

}
