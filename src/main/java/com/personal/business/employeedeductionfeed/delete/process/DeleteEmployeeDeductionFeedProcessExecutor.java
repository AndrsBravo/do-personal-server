package com.personal.business.employeedeductionfeed.delete.process;

import com.personal.business.employeedeductionfeed.delete.process.rules.DeleteEmployeeDeductionFeedRule;
import com.personal.business.employeedeductionfeed.entities.EmployeeDeductionFeed;
import com.personal.shared.process.SupplierProcessExecutor;

public class DeleteEmployeeDeductionFeedProcessExecutor extends SupplierProcessExecutor<DeleteEmployeeDeductionFeedProcess, EmployeeDeductionFeed> {

    public DeleteEmployeeDeductionFeedProcessExecutor() {
        super(new DeleteEmployeeDeductionFeedProcess(),
                DeleteEmployeeDeductionFeedRule::new
        );
    }

    public static DeleteEmployeeDeductionFeedProcessExecutor builder() {
        return new DeleteEmployeeDeductionFeedProcessExecutor();
    }

}
