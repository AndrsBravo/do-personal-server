package com.personal.backoffice.business.process.update;

import com.personal.backoffice.business.entities.Business;
import com.personal.backoffice.business.process.update.rules.UpdateBusinessRule;
import com.personal.backoffice.business.process.update.rules.UpdateFieldsParamsBusinessRule;
import com.personal.shared.process.SupplierProcessExecutor;

public class UpdateBusinessProcessExecutor extends SupplierProcessExecutor<UpdateBusinessProcess, Business> {

    public UpdateBusinessProcessExecutor() {
        super(new UpdateBusinessProcess(),
                UpdateFieldsParamsBusinessRule::new,
                UpdateBusinessRule::new
        );
    }

    public static UpdateBusinessProcessExecutor builder() {
        return new UpdateBusinessProcessExecutor();
    }

}
