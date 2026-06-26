package com.personal.backoffice.userrelation.api.routers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.personal.shared.api.BaseRouterTest;

import io.helidon.http.Status;
import io.helidon.webserver.testing.junit5.DirectClient;
import jakarta.json.JsonObject;

public class UserRelationRouterTest extends BaseRouterTest {

    public UserRelationRouterTest(DirectClient client) {
        super(client);
    }

    @Test
    public void testFilterUserRelation() {
        var input = JSON_FACTORY.createObjectBuilder()
                .add("all", "all")
                .build();

        var response = client.post("/v1/backoffice/user_relation/filter").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(response.status(), Status.OK_200);
    }

    @Test
    public void testCreateUserRelation() {

        var input = JSON_FACTORY.createObjectBuilder()
                .add("relation", "owner")
                .add("title", "User Owner")
                .add("description", "Este usuario es el propietario de esta entidad")
                .build();

        var response = client.post("/v1/backoffice/user_relation").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(response.status(), Status.CREATED_201);
    }

    @Test
    public void testUpdateUserRelation() {

        var input = JSON_FACTORY.createObjectBuilder()
                .add("id", "14d356fe")
                .add("title", "Owner")
                .build();

        var response = client.put("/v1/backoffice/user_relation").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(response.status(), Status.OK_200);
    }

    @Test
    public void testDeleteUserRelation() {

        var input = JSON_FACTORY.createObjectBuilder()
                .add("id", "14d356fe")
                .build();

        var response = client.delete("/v1/backoffice/user_relation/" + "14d356fe").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(response.status(), Status.OK_200);
    }

}
