package com.personal.backoffice.user.update.process;

import com.personal.backoffice.user.entities.User;
import com.personal.backoffice.user.update.process.rules.EditUserRule;
import com.personal.shared.process.SupplierProcessExecutor;

public class EditUserProcessExecutor extends SupplierProcessExecutor<EditUserProcess, User> {

    public EditUserProcessExecutor() {

        super(new EditUserProcess(),
                EditUserRule::new
        );
    }

    public static EditUserProcessExecutor builder() {
        return new EditUserProcessExecutor();
    }

}
