package com.personal.server;

import com.personal.backoffice.system.appdata.process.systemdata.SystemDataProcessExecutor;
import com.personal.backoffice.system.databases.process.migration.MigrationProcessExecutor;
import com.personal.server.config.AppConfig;
import com.personal.server.router.Routing;
import com.personal.server.system.appdata.DataReader;

import io.helidon.logging.common.LogConfig;
import io.helidon.webserver.WebServer;

public class Server {

    public static void run() {

        LogConfig.configureRuntime();

        // Config config = Services.get(Config.class);
        MigrationProcessExecutor.builder().init("").execute();

        SystemDataProcessExecutor.builder().init(
                DataReader.get().asJson("data/RD/system_data.json"))
                .execute();

        WebServer server = WebServer.builder()
                .config(AppConfig.config("server"))
                .routing(Routing::routing)
                .build()
                .start();

        System.out.println("WEB server is up! http://localhost:" + server.port());

    }

}
