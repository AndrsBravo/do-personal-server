package com.personal.server.config;

import io.helidon.config.Config;
import io.helidon.service.registry.Services;

public class AppConfig {

    private static Config config;

    private static void setUp() {

        if (config != null) {
            return;
        }

        config = Services.get(Config.class);
    }

    public static String get(String key) {
        setUp();
        return config.get(key).asString().orElse("");

    }

}
