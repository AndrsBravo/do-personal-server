package com.personal.shared.utils;

import java.util.UUID;

public class Identity {

    public static String shortUUID() {
        String id = UUID.randomUUID().toString();
        return id.substring(0, id.indexOf("-"));
    }

    public static String midUUID() {
        String id = UUID.randomUUID().toString();
        return id.substring(id.lastIndexOf("-") + 1);
    }

    public static UUID randomUUID() {
        return UUID.randomUUID();
    }

}
