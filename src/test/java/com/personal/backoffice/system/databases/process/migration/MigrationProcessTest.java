package com.personal.backoffice.system.databases.process.migration;

import static org.hamcrest.MatcherAssert.assertThat;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import com.personal.backoffice.system.databases.process.migration.rules.HealthCheckDataBaseConnectionRule;
import com.personal.backoffice.system.databases.process.migration.rules.MigrateSystemMasterDataBaseRule;

public class MigrationProcessTest {

    public MigrationProcessTest() {
    }

    @Test
    public void testMigrationProcess() {

        MigrationProcess migrationProcess = new MigrationProcess();

        assertThat(migrationProcess.isActive(), Matchers.is(false));

        HealthCheckDataBaseConnectionRule bStatusRule = new HealthCheckDataBaseConnectionRule();
        bStatusRule.apply(migrationProcess);

        assertThat(migrationProcess.getLogs().size(), Matchers.is(1));
        assertThat(migrationProcess.getLogs().get(0), Matchers.notNullValue());

    }

    @Test
    public void testSystemMigrationRuleOnMigrationProcess() {

        MigrationProcess migrationProcess = new MigrationProcess();

        assertThat(migrationProcess.isActive(), Matchers.is(false));

        MigrateSystemMasterDataBaseRule migrationRule = new MigrateSystemMasterDataBaseRule();
        migrationRule.apply(migrationProcess);

        assertThat(migrationProcess.getLogs().size(), Matchers.is(1));
        assertThat(migrationProcess.getLogs().get(0), Matchers.notNullValue());

    }

}
