package com.personal.backoffice.business.process.delete;

import com.personal.backoffice.business.entities.Business;
import com.personal.backoffice.business.process.delete.rules.DeleteBusinessRule;
import com.personal.shared.process.SupplierProcessExecutor;

public class DeleteBusinessProcessExecutor extends SupplierProcessExecutor<DeleteBusinessProcess, Business> {

    public DeleteBusinessProcessExecutor() {
        super(new DeleteBusinessProcess(),
                DeleteBusinessRule::new
        );
    }

    public static DeleteBusinessProcessExecutor builder() {
        return new DeleteBusinessProcessExecutor();
    }

}
