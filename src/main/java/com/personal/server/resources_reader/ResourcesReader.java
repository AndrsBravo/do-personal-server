package com.personal.server.resources_reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.stream.Collectors;

public class ResourcesReader {

    private static ResourcesReader instance;

    private static void theInstance() {
        if (instance == null) {
            instance = new ResourcesReader();
        }
    }

    private String readResourceFileAsString(String fileName) {
        // Use try-with-resources to ensure the InputStream is closed automatically
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName)) {
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

    public static String readResourceAsString(String resource) {
        theInstance();
        // The path is relative to the root of the classpath (no leading slash needed here)
        String content = instance.readResourceFileAsString(resource);
        return content;
    }

    private Properties readAsProperties(String propertiesFile) {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(propertiesFile)) {
            var properties = new Properties();
            properties.load(input);
            return properties;
        } catch (IOException ex) {
            return null;
        }

    }

    public Properties readResourceAsProperties(String propertiesFile) {

        return instance.readAsProperties(propertiesFile);
    }
}
