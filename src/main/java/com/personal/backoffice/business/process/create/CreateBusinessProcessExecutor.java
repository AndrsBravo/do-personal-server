package com.personal.backoffice.business.process.create;

import com.personal.backoffice.business.entities.Business;
import com.personal.backoffice.business.process.create.rules.AssociateBusinessUserRule;
import com.personal.backoffice.business.process.create.rules.CreateBusinessDataBaseRule;
import com.personal.backoffice.business.process.create.rules.CreateBusinessRule;
import com.personal.backoffice.business.process.create.rules.MigrateBusinessDataBaseRule;
import com.personal.backoffice.business.process.create.rules.ValidateBusinessRule;
import com.personal.backoffice.business.process.create.rules.ValidateBusinessUserRelationRule;
import com.personal.backoffice.business.process.create.rules.ValidateBusinessUserRoleRule;
import com.personal.shared.process.SupplierProcessExecutor;

public class CreateBusinessProcessExecutor extends SupplierProcessExecutor<CreateBusinessProcess, Business> {

    public CreateBusinessProcessExecutor() {
        super(new CreateBusinessProcess(),
                ValidateBusinessRule::new,
                CreateBusinessDataBaseRule::new,
                MigrateBusinessDataBaseRule::new,
                CreateBusinessRule::new,
                ValidateBusinessUserRoleRule::new,
                ValidateBusinessUserRelationRule::new,
                AssociateBusinessUserRule::new
        );
    }

    public static CreateBusinessProcessExecutor builder() {
        return new CreateBusinessProcessExecutor();
    }

}
