package com.personal.server;

import com.personal.backoffice.system.databases.process.migration.MigrationProcessExecutor;
import com.personal.server.router.Routing;

import io.helidon.config.Config;
import io.helidon.logging.common.LogConfig;
import io.helidon.service.registry.Services;
import io.helidon.webserver.WebServer;

public class Server {

    public static void run() {

        LogConfig.configureRuntime();

        Config config = Services.get(Config.class);

        MigrationProcessExecutor.builder().init("").execute();

        WebServer server = WebServer.builder()
                .config(config.get("server"))
                .routing(Routing::routing)
                .build()
                .start();

        System.out.println("WEB server is up! http://localhost:" + server.port());

    }

}
