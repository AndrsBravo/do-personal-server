package com.personal.server.dbclient;

import static org.hamcrest.MatcherAssert.assertThat;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import io.helidon.config.Config;

public class DbClientMSSQLFactoryTest {

    String poolName = "master";

    public DbClientMSSQLFactoryTest() {
    }

    @Test
    public void testDbConfig() {

        Config result = DbClientMSSQLFactory.dbConfig(poolName);
        assertThat(result.get("connection.poolName").asString().get(), Matchers.is(poolName));
        assertThat(result.get("connection.url").asString().get(), Matchers.is("jdbc:sqlserver://localhost:1433;databaseName=master;encrypt=true;trustServerCertificate=true;"));

    }

    @Test
    public void testDbClient() {

        var testDb = DbClientMSSQLFactory.testDb(poolName);

        assertThat(testDb, Matchers.is(1));

    }

}
