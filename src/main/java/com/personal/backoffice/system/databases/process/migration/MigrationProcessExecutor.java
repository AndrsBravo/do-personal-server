package com.personal.backoffice.system.databases.process.migration;

import com.personal.backoffice.system.databases.process.migration.rules.CreateManagementDataBaseRule;
import com.personal.backoffice.system.databases.process.migration.rules.CreateSystemMasterDataBaseRule;
import com.personal.backoffice.system.databases.process.migration.rules.HealthCheckDataBaseConnectionRule;
import com.personal.backoffice.system.databases.process.migration.rules.MigrateManagementDataBaseRule;
import com.personal.backoffice.system.databases.process.migration.rules.MigrateSystemMasterDataBaseRule;
import com.personal.shared.process.SupplierProcessExecutor;

public class MigrationProcessExecutor extends SupplierProcessExecutor<MigrationProcess, String> {

    public MigrationProcessExecutor() {
        super(new MigrationProcess(),
                HealthCheckDataBaseConnectionRule::new,
                CreateManagementDataBaseRule::new,
                MigrateManagementDataBaseRule::new,
                CreateSystemMasterDataBaseRule::new,
                MigrateSystemMasterDataBaseRule::new
        );

    }

    public static MigrationProcessExecutor builder() {
        return new MigrationProcessExecutor();
    }

}
