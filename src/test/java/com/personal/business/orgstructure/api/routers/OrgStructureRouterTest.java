package com.personal.business.orgstructure.api.routers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.personal.shared.api.BaseRouterTest;

import io.helidon.http.Status;
import io.helidon.webserver.testing.junit5.DirectClient;
import jakarta.json.JsonObject;

public class OrgStructureRouterTest extends BaseRouterTest {

    public OrgStructureRouterTest(DirectClient client) {
        super(client);
    }

    @Test
    public void testFilterStructures() {
        var input = JSON_FACTORY.createObjectBuilder()
                .add("all", "all")
                .build();

        var response = client.post("/v1/business/org_structures/filter").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(response.status(), Status.OK_200);
    }

    @Test
    public void testCreateStructures() {

        var input = JSON_FACTORY.createObjectBuilder()
                .add("countryId", "6ff7f312")
                .add("level", 1)
                .add("structure", "Junta")
                .add("title", "Junta de Accionistas")
                .add("description", "Junta de propietarios de la organización")
                .build();

        var response = client.post("/v1/business/org_structures").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(Status.CREATED_201, response.status());
    }

    @Test
    public void testUpdateStructures() {

        var input = JSON_FACTORY.createObjectBuilder()
                .add("id", "6934836b")
                .add("countryId", "6ff7f312")
                .add("structure", "Junta")
                .add("description", "Junta de propietarios de la organización")
                .build();

        var response = client.put("/v1/business/org_structures").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(response.status(), Status.OK_200);
    }

    @Test
    public void testDeleteStructures() {

        var input = JSON_FACTORY.createObjectBuilder()
                .add("id", "6934836b")
                .build();

        var response = client.delete("/v1/business/org_structures/" + "6934836b").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(response.status(), Status.OK_200);
    }

}
