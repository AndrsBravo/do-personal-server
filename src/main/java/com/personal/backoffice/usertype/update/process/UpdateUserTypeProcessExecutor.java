package com.personal.backoffice.usertype.update.process;

import com.personal.backoffice.usertype.update.process.rules.UpdateFieldsParamsUserTypesRule;
import com.personal.backoffice.usertype.update.process.rules.UpdateUserTypeRule;
import com.personal.shared.entities.TypeEntityBase;
import com.personal.shared.process.SupplierProcessExecutor;

public class UpdateUserTypeProcessExecutor extends SupplierProcessExecutor<UpdateUserTypeProcess, TypeEntityBase> {

    public UpdateUserTypeProcessExecutor() {
        super(new UpdateUserTypeProcess(),
                UpdateFieldsParamsUserTypesRule::new,
                UpdateUserTypeRule::new
        );
    }

    public static UpdateUserTypeProcessExecutor builder() {
        return new UpdateUserTypeProcessExecutor();
    }

}
