package com.personal.backoffice.system.appdata.process.systemdata;

import com.personal.backoffice.system.appdata.process.systemdata.rules.SystemDataCountryRule;
import com.personal.shared.process.SupplierProcessExecutor;

import jakarta.json.JsonObject;

public class SystemDataProcessExecutor extends SupplierProcessExecutor<SystemDataProcess, JsonObject> {

    public SystemDataProcessExecutor() {
        super(new SystemDataProcess(),
                SystemDataCountryRule::new
        );

    }

    public static SystemDataProcessExecutor builder() {
        return new SystemDataProcessExecutor();
    }

}
