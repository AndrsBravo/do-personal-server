package com.personal.server.system.appdata;

import java.io.InputStream;

import com.personal.server.resources.ResourcesReader;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class DataReader {

    public static DataReader get() {

        return new DataReader();
    }

    public JsonObject asJson(String fileName) {

        JsonObject result;

        InputStream stream = ResourcesReader.read().asStream(fileName);
        if (stream == null) {
            result = Json.createObjectBuilder().build();
            return result;
        }
        try (JsonReader reader = Json.createReader(stream)) {

            result = reader.readObject();

        }

        return result;
    }
}
