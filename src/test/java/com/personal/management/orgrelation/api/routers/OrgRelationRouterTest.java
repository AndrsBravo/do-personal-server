package com.personal.management.orgrelation.api.routers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.personal.shared.api.BaseRouterTest;

import io.helidon.http.Status;
import io.helidon.webserver.testing.junit5.DirectClient;
import jakarta.json.JsonObject;

public class OrgRelationRouterTest extends BaseRouterTest {

    public OrgRelationRouterTest(DirectClient client) {
        super(client);
    }

    @Test
    public void testFilterRelation() {
        var input = JSON_FACTORY.createObjectBuilder()
                .add("all", "all")
                .build();

        var response = client.post("/v1/management/org_relations/filter").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(response.status(), Status.OK_200);
    }

    @Test
    public void testCreateRelation() {

        var input = JSON_FACTORY.createObjectBuilder()
                .add("countryId", "6ff7f312")
                .add("hierarchyId", "28a43196")
                .add("structureId", "6934836b")
                .build();

        var response = client.post("/v1/management/org_relations").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(Status.CREATED_201, response.status());
    }

    @Test
    public void testUpdateRelation() {

        var input = JSON_FACTORY.createObjectBuilder()
                .add("id", "28a43196")
                .add("countryId", "6ff7f312")
                .add("hierarchy", "Miembro")
                .add("description", "Miembro de la Junta de Accionistas de la Organización")
                .build();

        var response = client.put("/v1/management/org_relations").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(response.status(), Status.OK_200);
    }

    @Test
    public void testDeleteRelation() {

        var input = JSON_FACTORY.createObjectBuilder()
                .add("id", "28a43196")
                .build();

        var response = client.delete("/v1/management/org_relations/" + "28a43196").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(response.status(), Status.OK_200);
    }

}
