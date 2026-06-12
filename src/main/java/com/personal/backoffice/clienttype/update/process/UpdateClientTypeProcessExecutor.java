package com.personal.backoffice.clienttype.update.process;

import com.personal.backoffice.clienttype.update.process.rules.UpdateClientTypeRule;
import com.personal.backoffice.clienttype.update.process.rules.UpdateFieldsParamsClientTypesRule;
import com.personal.shared.entities.TypeEntityBase;
import com.personal.shared.process.SupplierProcessExecutor;

public class UpdateClientTypeProcessExecutor extends SupplierProcessExecutor<UpdateClientTypeProcess, TypeEntityBase> {

    public UpdateClientTypeProcessExecutor() {
        super(new UpdateClientTypeProcess(),
                UpdateFieldsParamsClientTypesRule::new,
                UpdateClientTypeRule::new
        );
    }

    public static UpdateClientTypeProcessExecutor builder() {
        return new UpdateClientTypeProcessExecutor();
    }

}
