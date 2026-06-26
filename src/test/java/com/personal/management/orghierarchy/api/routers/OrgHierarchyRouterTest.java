package com.personal.management.orghierarchy.api.routers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.personal.shared.api.BaseRouterTest;

import io.helidon.http.Status;
import io.helidon.webserver.testing.junit5.DirectClient;
import jakarta.json.JsonObject;

public class OrgHierarchyRouterTest extends BaseRouterTest {

    public OrgHierarchyRouterTest(DirectClient client) {
        super(client);
    }

    @Test
    public void testFilterHierarchy() {
        var input = JSON_FACTORY.createObjectBuilder()
                .add("all", "all")
                .build();

        var response = client.post("/v1/management/org_hierarchies/filter").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(response.status(), Status.OK_200);
    }

    @Test
    public void testCreateHierarchy() {

        var input = JSON_FACTORY.createObjectBuilder()
                .add("countryId", "6ff7f312")
                .add("level", 1)
                .add("hierarchy", "Miembro")
                .add("title", "Miembro de la Junta de Accionistas")
                .add("description", "Miembro de la Junta de Accionistas de la Organización")
                .build();

        var response = client.post("/v1/management/org_hierarchies").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(Status.CREATED_201, response.status());
    }

    @Test
    public void testUpdateHierarchy() {

        var input = JSON_FACTORY.createObjectBuilder()
                .add("id", "28a43196")
                .add("countryId", "6ff7f312")
                .add("hierarchy", "Miembro")
                .add("description", "Miembro de la Junta de Accionistas de la Organización")
                .build();

        var response = client.put("/v1/management/org_hierarchies").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(response.status(), Status.OK_200);
    }

    @Test
    public void testDeleteHierarchy() {

        var input = JSON_FACTORY.createObjectBuilder()
                .add("id", "28a43196")
                .build();

        var response = client.delete("/v1/management/org_hierarchies/" + "28a43196").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(response.status(), Status.OK_200);
    }

}
