package com.personal.business.employeebenefitfeed.create.process;

import com.personal.business.employeebenefitfeed.create.process.rules.CreateEmployeeBenefitFeedRule;
import com.personal.business.employeebenefitfeed.create.process.rules.ValidateEmployeeBenefitFeedRule;
import com.personal.business.employeebenefitfeed.entities.EmployeeBenefitFeed;
import com.personal.shared.process.SupplierProcessExecutor;

public class CreateEmployeeBenefitFeedProcessExecutor extends SupplierProcessExecutor<CreateEmployeeBenefitFeedProcess, EmployeeBenefitFeed> {

    public CreateEmployeeBenefitFeedProcessExecutor() {
        super(new CreateEmployeeBenefitFeedProcess(),
                ValidateEmployeeBenefitFeedRule::new,
                CreateEmployeeBenefitFeedRule::new
        );
    }

    public static CreateEmployeeBenefitFeedProcessExecutor builder() {
        return new CreateEmployeeBenefitFeedProcessExecutor();
    }

}
