package com.personal.backoffice.system.appdata.process.management;

import com.personal.shared.process.SupplierProcess;

import jakarta.json.JsonObject;

public class ManagementDataProcess extends SupplierProcess<JsonObject> {

    public ManagementDataProcess() {
        super("management_data_process");
    }

}
