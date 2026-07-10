package com.personal.server.resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.stream.Collectors;

public class ResourcesReader {

    public static ResourcesReader read() {
        return new ResourcesReader();

    }

    public InputStream asStream(String propertiesFile) {

        return getClass().getClassLoader().getResourceAsStream(propertiesFile);

    }

    public String asString(String fileName) {
        // Use try-with-resources to ensure the InputStream is closed automatically
        try (InputStream inputStream = this.asStream(fileName)) {
            if (inputStream == null) {
                throw new IllegalArgumentException(fileName + " is not found");
            }

            // Read the input stream into a String
            return new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                    .lines()
                    .collect(Collectors.joining(System.lineSeparator()));

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Properties asProperties(String propertiesFile) {
        try (InputStream input = this.asStream(propertiesFile)) {
            var properties = new Properties();
            properties.load(input);
            return properties;
        } catch (IOException ex) {
            return null;
        }

    }

}
