package com.personal.backoffice.system.appdata.process.management;

import com.personal.backoffice.system.appdata.process.management.rules.ManagementDataRule;
import com.personal.shared.process.SupplierProcessExecutor;

import jakarta.json.JsonObject;

public class ManagementDataProcessExecutor extends SupplierProcessExecutor<ManagementDataProcess, JsonObject> {

    public ManagementDataProcessExecutor() {
        super(new ManagementDataProcess(),
                ManagementDataRule::new
        );

    }

    public static ManagementDataProcessExecutor builder() {
        return new ManagementDataProcessExecutor();
    }

}
