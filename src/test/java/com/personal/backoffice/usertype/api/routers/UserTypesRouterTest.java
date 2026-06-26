package com.personal.backoffice.usertype.api.routers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.personal.shared.api.BaseRouterTest;

import io.helidon.http.Status;
import io.helidon.webserver.testing.junit5.DirectClient;
import jakarta.json.JsonObject;

public class UserTypesRouterTest extends BaseRouterTest {

    public UserTypesRouterTest(DirectClient client) {
        super(client);
    }

    @Test
    public void testFilterUserTypes() {
        var input = JSON_FACTORY.createObjectBuilder()
                .add("all", "all")
                .build();

        var response = client.post("/v1/backoffice/user_types/filter").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(response.status(), Status.OK_200);
    }

    @Test
    public void testCreateUserTypes() {

        var input = JSON_FACTORY.createObjectBuilder()
                .add("type", "test_user")
                .add("description", "New User type for testing purposes")
                .build();

        var response = client.post("/v1/backoffice/user_types").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(response.status(), Status.CREATED_201);
    }

    @Test
    public void testUpdateUserTypes() {

        var input = JSON_FACTORY.createObjectBuilder()
                .add("id", "28bdd4f0")
                .add("description", "User type Updated")
                .build();

        var response = client.put("/v1/backoffice/user_types").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(response.status(), Status.OK_200);
    }

    @Test
    public void testDeleteUserTypes() {

        var input = JSON_FACTORY.createObjectBuilder()
                .add("id", "8743b020")
                .build();

        var response = client.delete("/v1/backoffice/user_types/" + "28bdd4f0").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(response.status(), Status.OK_200);
    }

}
