package com.personal.backoffice.system.databases.process.migration;

import static org.hamcrest.MatcherAssert.assertThat;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class MigrationProcessExecutorTest {

    public MigrationProcessExecutorTest() {
    }

    @Test
    public void testBuilder() {
        MigrationProcess migrationProcess = MigrationProcessExecutor
                .builder().init("")
                .onStateChanged((state, process) -> {
                    System.out.printf("State has Changed on %s. New State: %s\n ", process.getCode(), state);
                }).execute();

        assertThat(migrationProcess.isActive(), Matchers.is(false));

        assertThat(migrationProcess.getLogs().size(), Matchers.greaterThan(0));
        assertThat(migrationProcess.getLogs().get(0), Matchers.notNullValue());

        System.out.printf("Process: %s\n", migrationProcess.getClass().getName());
        migrationProcess.getLogs().stream().forEach(log -> {
            System.out.printf(" -ProcessRule: %s\n", log.code());
            System.out.printf("  ShouldDo: %s\n", log.should());
            System.out.printf("  Result: %s\n", log.result());
        });

    }

}
