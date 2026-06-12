package com.personal.business.employeebenefitfeed.delete.process;

import com.personal.business.employeebenefitfeed.delete.process.rules.DeleteEmployeeBenefitFeedRule;
import com.personal.business.employeebenefitfeed.entities.EmployeeBenefitFeed;
import com.personal.shared.process.SupplierProcessExecutor;

public class DeleteEmployeeBenefitFeedProcessExecutor extends SupplierProcessExecutor<DeleteEmployeeBenefitFeedProcess, EmployeeBenefitFeed> {

    public DeleteEmployeeBenefitFeedProcessExecutor() {
        super(new DeleteEmployeeBenefitFeedProcess(),
                DeleteEmployeeBenefitFeedRule::new
        );
    }

    public static DeleteEmployeeBenefitFeedProcessExecutor builder() {
        return new DeleteEmployeeBenefitFeedProcessExecutor();
    }

}
