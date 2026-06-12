package com.personal.server.dbclient;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import io.helidon.config.Config;
import io.helidon.config.ConfigSources;
import io.helidon.dbclient.DbClient;
import io.helidon.service.registry.Services;

public class DbClientMSSQLFactory {

    private static final Map<String, String> configProperties = new ConcurrentHashMap<>();
    private static final Map<String, Config> configMap = new ConcurrentHashMap<>();
    private static final Map<String, DbClient> dbClients = new ConcurrentHashMap<>();
    private static int Index = 0;

    public static Config dbConfig(String poolName) {

        if (configMap.containsKey(poolName)) {
            return configMap.get(poolName);
        }
        //System.out.println("-------------------------------- Creando la configuracion de: " + poolName + " " + Index + "  -------------------------");
        Config config = Services.get(Config.class);
        Config dbConfig = config.get("db");

        var url = String.format(dbConfig.get("connection.url").asString().get(), poolName);

        configProperties.put("connection.url", url);
        configProperties.put("connection.poolName", poolName);

        Config dbOverriddenConfig = Config.builder()
                .sources(ConfigSources.create(configProperties),
                        ConfigSources.create(dbConfig))
                .build();

        configMap.put(url, config);
        return dbOverriddenConfig;

    }

    public static Optional<DbClient> DbClient(String poolName) {

        if (dbClients.containsKey(poolName) && dbClients.get(poolName) != null) {
            return Optional.of(dbClients.get(poolName));
        }
        //System.out.println("-------------------------------- Creando connection " + poolName + " " + Index + "  -------------------------");
        Config dbConfig = dbConfig(poolName);
        try {

            DbClient dbClient = DbClient.create(dbConfig);

            dbClients.put(poolName, dbClient);
            return Optional.of(dbClient);
        } catch (Exception e) {

        }
        return Optional.empty();
    }

    public static Optional<DbClient> SystemMaster() {
        return DbClient("system_master");

    }

    public static Optional<DbClient> Management() {
        return DbClient("management_db");

    }

    public static Optional<DbClient> Master() {
        return DbClient("master");
    }

    public static void deleteDbClient(String poolName) {

        if (!dbClients.containsKey(poolName)) {
            return;
        }

        dbClients.get(poolName).close();
        dbClients.remove(poolName);
    }

    public static long testDb(String dbName) {

        try {
            var dbClient = DbClientMSSQLFactory.Master();

            if (!dbClient.isPresent()) {
                return -1;

            }

            var result = dbClient.get().execute().createGet("SELECT * FROM sys.databases WHERE name = :name").addParam("name", dbName).execute();
            return result.stream().count();
        } catch (Exception e) {
            //System.out.println("Error testing connection to database " + dbName + ": " + e.getMessage());
            return -1;
        }

    }

}
