package com.personal.business.employeedeductionfeed.create.process;

import com.personal.business.employeedeductionfeed.create.process.rules.CreateEmployeeDeductionFeedRule;
import com.personal.business.employeedeductionfeed.create.process.rules.ValidateEmployeeDeductionFeedRule;
import com.personal.business.employeedeductionfeed.entities.EmployeeDeductionFeed;
import com.personal.shared.process.SupplierProcessExecutor;

public class CreateEmployeeDeductionFeedProcessExecutor extends SupplierProcessExecutor<CreateEmployeeDeductionFeedProcess, EmployeeDeductionFeed> {

    public CreateEmployeeDeductionFeedProcessExecutor() {
        super(new CreateEmployeeDeductionFeedProcess(),
                ValidateEmployeeDeductionFeedRule::new,
                CreateEmployeeDeductionFeedRule::new
        );
    }

    public static CreateEmployeeDeductionFeedProcessExecutor builder() {
        return new CreateEmployeeDeductionFeedProcessExecutor();
    }

}
