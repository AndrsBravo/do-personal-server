package com.personal.server.flyway;

import static org.hamcrest.MatcherAssert.assertThat;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import com.personal.server.dbclient.DbClientMSSQLFactory;

public class FlyWayMigrationFactoryTest {

    public FlyWayMigrationFactoryTest() {
    }

    @Test
    public void testConfigureRuntime() {

        //Test personal db
        var testPersonal = DbClientMSSQLFactory.testDb("personal");

        assertThat(testPersonal, Matchers.is(1L));

        //Test system_master db
        var testSysMaster = DbClientMSSQLFactory.testDb("system_master");

        assertThat(testSysMaster, Matchers.is(1L));

        //Test client_master db
        var testClientMaster = DbClientMSSQLFactory.testDb("client_master");

        assertThat(testClientMaster, Matchers.is(1L));

        //Test client_demo db
        var testClientDemo = DbClientMSSQLFactory.testDb("client_demo");

        assertThat(testClientDemo, Matchers.is(1L));

    }

}
