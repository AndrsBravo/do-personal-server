package com.personal.business.user.update.process;

import com.personal.business.user.entities.User;
import com.personal.business.user.update.process.rules.EditUserRule;
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
