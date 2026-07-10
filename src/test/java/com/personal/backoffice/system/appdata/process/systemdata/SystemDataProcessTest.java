package com.personal.backoffice.system.appdata.process.systemdata;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

import com.personal.server.system.appdata.DataReader;

public class SystemDataProcessTest {

    public SystemDataProcessTest() {
    }

    @Test
    public void testSystemDataProcess() {

        var process = SystemDataProcessExecutor.builder().init(
                DataReader.get().asJson("data/RD/system_data.json"))
                .execute();

        System.out.println("Process Logs: " + process.getLogs().size());
        process.getLogs().forEach(log -> System.out.println("Should: " + log.should() + "Done: " + log.result()));
        assertNotNull(process);
    }

}
