package com.personal.server.flyway;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.output.MigrateResult;

import com.personal.server.hikari.HikariDataSourceConfig;

import io.helidon.config.Config;

public class FlyWayMigrationFactory {

    private static Config config;

    public static MigrateResult migrate(String dbName, String migrate_location) {
        return Flyway.configure()
                .dataSource(HikariDataSourceConfig.getDataSource(dbName))
                .locations("classpath:" + migrate_location)
                .load()
                .migrate();

    }

}
