package com.personal.server.system.appdata;

import java.io.File;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import jakarta.json.JsonObject;

public class DataReaderTest {

    public DataReaderTest() {
    }

    @Test
    public void testFile() {

        String fileName[] = new String[]{"data", "RD", "application_data.json"};
        var file = String.join(File.separator, fileName);
        JsonObject result = DataReader.get().asJson(file);
        Assertions.assertNotNull(result);

    }

}
