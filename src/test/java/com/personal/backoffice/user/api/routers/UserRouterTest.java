package com.personal.backoffice.user.api.routers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.personal.shared.api.BaseRouterTest;

import io.helidon.http.Status;
import io.helidon.webserver.testing.junit5.DirectClient;
import jakarta.json.JsonObject;

public class UserRouterTest extends BaseRouterTest {

    public UserRouterTest(DirectClient client) {
        super(client);
    }

    @Test
    void filterAllUserRoutingTest() {

        System.out.println("Testing user filter route...");
        var input = JSON_FACTORY.createObjectBuilder()
                .build();

        var response = client.post("/v1/backoffice/users/filter").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(response.status(), Status.OK_200);

    }

    @Test
    void filterUserByIdRoutingTest() {

        System.out.println("Testing user filter route...");
        var input = JSON_FACTORY.createObjectBuilder()
                .add("id", "5447034767e0")
                .build();

        var response = client.post("/v1/backoffice/users/filter").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(response.status(), Status.OK_200);

    }

    @Test
    void filterUserByEmailRoutingTest() {

        System.out.println("Testing user filter route...");
        var input = JSON_FACTORY.createObjectBuilder()
                .add("email", "hubravo13@gmail.com")
                .build();

        var response = client.post("/v1/backoffice/users/filter").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(response.status(), Status.OK_200);

    }

    @Test
    void testCreateUserRouting() {

        System.out.println("Testing Create User route...");
        var input = JSON_FACTORY.createObjectBuilder()
                .add("email", "lbravo@gmail.com")
                .add("userTypeid", "28bdd4f0")
                .add("userName", "abravo")
                .add("name", "Andres")
                .add("lastName", "Bravo")
                .build();

        var response = client.post("/v1/backoffice/users").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(response.status(), Status.CREATED_201);

    }

    @Test
    void testUpdateUserRouting() {

        System.out.println("Testing Update User route...");
        var input = JSON_FACTORY.createObjectBuilder()
                .add("id", "5447034767e0")
                .add("lastName", "Bravo Marte")
                .build();

        var response = client.put("/v1/backoffice/users").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(response.status(), Status.CREATED_201);

    }

    @Test
    void testAssociateUserClientRouting() {

        System.out.println("Testing Associate User Client route...");
        var input = JSON_FACTORY.createObjectBuilder()
                .add("clientId", "92ac76d6c093")
                .add("userId", "5447034767e0")
                .add("userRoleId", "8aa4ef8d")
                .add("userRelationId", "0349621b")
                .build();

        var response = client.post("/v1/backoffice/users/associatedclients").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(response.status(), Status.CREATED_201);

    }

    @Test
    void testFilterAssociatedUserClientRouting() {

        System.out.println("Testing Filter Associated User Client route...");
        var input = JSON_FACTORY.createObjectBuilder()
                .add("userId", "5447034767e0")
                .build();

        var response = client.post("/v1/backoffice/users/associatedclients/filter").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(Status.OK_200, response.status());

    }

    @Test
    void testUpdateAssociatedUserClientRouting() {

        System.out.println("Testing Update Associated User Client route...");
        var input = JSON_FACTORY.createObjectBuilder()
                .add("clientId", "92ac76d6c093")
                .add("userId", "5447034767e0")
                .add("userRoleId", "8aa4ef8d")
                .add("userRelationId", "0349621b")
                .build();

        var response = client.put("/v1/backoffice/users/associatedclients").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(Status.OK_200, response.status());

    }

    @Test
    void testDeleteAssociatedUserClientRouting() {

        System.out.println("Testing Delete Associated User Client route...");
        var input = JSON_FACTORY.createObjectBuilder()
                .add("clientId", "92ac76d6c093")
                .add("userId", "5447034767e0")
                .build();

        var response = client.delete("/v1/backoffice/users/associatedclients").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(Status.OK_200, response.status());

    }

    @Test
    void testAssociateUserBusinessRouting() {

        System.out.println("Testing Associate User Client route...");
        var input = JSON_FACTORY.createObjectBuilder()
                .add("clientId", "92ac76d6c093")
                .add("userId", "5447034767e0")
                .add("userRoleId", "8aa4ef8d")
                .add("userRelationId", "0349621b")
                .build();

        var response = client.post("/v1/backoffice/users/associatedbusiness").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(response.status(), Status.CREATED_201);

    }

    @Test
    void testFilterAssociatedUserBusinessRouting() {

        System.out.println("Testing Filter Associated User Client route...");
        var input = JSON_FACTORY.createObjectBuilder()
                .add("userId", "5447034767e0")
                .build();

        var response = client.post("/v1/backoffice/users/associatedbusiness/filter").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(Status.OK_200, response.status());

    }

    @Test
    void testUpdateAssociatedUserBusinessRouting() {

        System.out.println("Testing Update Associated User Client route...");
        var input = JSON_FACTORY.createObjectBuilder()
                .add("clientId", "92ac76d6c093")
                .add("userId", "5447034767e0")
                .add("userRoleId", "8aa4ef8d")
                .add("userRelationId", "0349621b")
                .build();

        var response = client.put("/v1/backoffice/users/associatedbusiness").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(Status.OK_200, response.status());

    }

    @Test
    void testDeleteAssociatedUserBusinessRouting() {

        System.out.println("Testing Delete Associated User Client route...");
        var input = JSON_FACTORY.createObjectBuilder()
                .add("clientId", "92ac76d6c093")
                .add("userId", "5447034767e0")
                .build();

        var response = client.delete("/v1/backoffice/users/associatedbusiness").submit(input, JsonObject.class);

        System.out.println("Response: " + response.entity());
        System.out.println(response.status().code());
        assertEquals(Status.OK_200, response.status());

    }

}
