package com.personal.backoffice.system.appdata.process.systemdata;

import com.personal.shared.process.SupplierProcess;

import jakarta.json.JsonObject;

public class SystemDataProcess extends SupplierProcess<JsonObject> {

    public SystemDataProcess() {
        super("system_data_process");
    }

}
