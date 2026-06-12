package com.personal.backoffice.userrole.api.routers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.personal.backoffice.api.BaseRouterTest;

import io.helidon.http.Status;
import io.helidon.webserver.testing.junit5.DirectClient;
import jakarta.json.JsonObject;

public class UserRolesRouterTest extends BaseRouterTest {

    public UserRolesRouterTest(DirectClient client) {
        super(client);
    }

    @Test
    public void testFilterUserRoles() {
        var input = JSON_FACTORY.createObjectBuilder()
                .add("all", "all")
                .build();

        var response = client.post("/v1/backoffice/user_role/filter").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(response.status(), Status.OK_200);
    }

    @Test
    public void testCreateUserRoles() {

        var input = JSON_FACTORY.createObjectBuilder()
                .add("role", "admin")
                .add("title", "User Admin")
                .add("description", "Usuario con permisos de administrador en esta entidad")
                .build();

        var response = client.post("/v1/backoffice/user_role").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(response.status(), Status.CREATED_201);
    }

    @Test
    public void testUpdateUserRoles() {

        var input = JSON_FACTORY.createObjectBuilder()
                .add("id", "28bdd4f0")
                .add("description", "User type Updated")
                .build();

        var response = client.put("/v1/backoffice/user_role").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(response.status(), Status.OK_200);
    }

    @Test
    public void testDeleteUserRoles() {

        var input = JSON_FACTORY.createObjectBuilder()
                .add("id", "8743b020")
                .build();

        var response = client.delete("/v1/backoffice/user_role/" + "28bdd4f0").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(response.status(), Status.OK_200);
    }

}
