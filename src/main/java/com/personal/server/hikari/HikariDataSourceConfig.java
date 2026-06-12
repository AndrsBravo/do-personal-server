package com.personal.server.hikari;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariDataSourceConfig {

    private static HikariConfig defaultDataSourceConfig;
    private static String propertiesFileName = "/hikari.properties";

    private static final Map<String, HikariDataSource> dataSourceMap = new HashMap<>();

    public static void config() {

        if (defaultDataSourceConfig != null) {
            return;
        }

        defaultDataSourceConfig = new HikariConfig(propertiesFileName);

    }

    public static HikariConfig dataSourceConfig(String poolName) {

        config();
        var newDataSourceConfig = new HikariConfig(propertiesFileName);
        newDataSourceConfig.setPoolName(poolName);
        newDataSourceConfig.setCatalog(poolName);
        newDataSourceConfig.setJdbcUrl(String.format(defaultDataSourceConfig.getJdbcUrl(), poolName));
        return newDataSourceConfig;
    }

    public static DataSource getDataSource(String poolName) {
        if (dataSourceMap.containsKey(poolName) && dataSourceMap.get(poolName).isRunning()) {
            return dataSourceMap.get(poolName);
        }
        //System.out.println("-------------------------------- Creando Hikari DataSource " + poolName + "  -------------------------");
        var newDataSourceConfig = dataSourceConfig(poolName);

        var dataSource = new HikariDataSource(newDataSourceConfig);
        dataSourceMap.put(poolName, dataSource);

        return dataSourceMap.get(poolName);
    }

    public static Connection getConnection(String poolName) {

        var dataSource = getDataSource(poolName);

        try {

            return dataSource.getConnection();
        } catch (SQLException e) {
            return null;
        }

    }

    public static void terminate(String poolName) {
        if (!dataSourceMap.containsKey(poolName)) {
            return;
        }
        var dataSource = dataSourceMap.get(poolName);
        dataSource.close();

        dataSourceMap.remove(poolName);

    }

}
