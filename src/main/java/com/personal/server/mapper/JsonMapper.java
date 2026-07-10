package com.personal.server.mapper;

import jakarta.json.JsonObject;
import jakarta.json.JsonValue;
import jakarta.json.bind.JsonbBuilder;

public class JsonMapper {

    public static <T> T fromJson(String json, Class<T> clase) {

        return JsonbBuilder.create().fromJson(json, clase);

    }

    public static <T> T fromJson(JsonObject json, Class<T> clase) {

        return JsonbBuilder.create().fromJson(json.toString(), clase);

    }

    public static <T> T fromJson(JsonValue json, Class<T> clase) {

        return JsonbBuilder.create().fromJson(json.toString(), clase);

    }
}
