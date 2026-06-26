package com.personal.backoffice.commercial.entity.api.routers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.personal.shared.api.BaseRouterTest;

import io.helidon.http.Status;
import io.helidon.webserver.testing.junit5.DirectClient;
import jakarta.json.JsonObject;

public class CommercialEntityRouterTest extends BaseRouterTest {

    public CommercialEntityRouterTest(DirectClient client) {
        super(client);
    }

    @Test
    public void testFilterCommercialEntity() {
        var input = JSON_FACTORY.createObjectBuilder()
                .add("all", "all")
                .build();

        var response = client.post("/v1/backoffice/commercial_entity/filter").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(response.status(), Status.OK_200);
    }

    @Test
    public void testCreateCommercialEntity() {

        var input = JSON_FACTORY.createObjectBuilder()
                .add("entity", "client")
                .add("title", "Clientes")
                .add("description", "Clientes que puede tener un plan comercial")
                .build();

        var response = client.post("/v1/backoffice/commercial_entity").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(response.status(), Status.CREATED_201);
    }

    @Test
    public void testUpdateCommercialEntity() {

        var input = JSON_FACTORY.createObjectBuilder()
                .add("id", "708e4710")
                .add("description", "Entidad Cliente que representa a los clientes que puede tener un plan comercial")
                .build();

        var response = client.put("/v1/backoffice/commercial_entity").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(response.status(), Status.OK_200);
    }

    @Test
    public void testDeleteCommercialEntity() {

        var input = JSON_FACTORY.createObjectBuilder()
                .add("id", "708e4710")
                .build();

        var response = client.delete("/v1/backoffice/commercial_entity/" + "708e4710").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(response.status(), Status.OK_200);
    }

}
