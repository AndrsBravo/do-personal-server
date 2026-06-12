package com.personal.business.employeebenefitfeed.update.process;

import com.personal.business.employeebenefitfeed.entities.EmployeeBenefitFeed;
import com.personal.business.employeebenefitfeed.update.process.rules.UpdateEmployeeBenefitFeedRule;
import com.personal.business.employeebenefitfeed.update.process.rules.UpdateFieldsParamsEmployeeBenefitFeedRule;
import com.personal.shared.process.SupplierProcessExecutor;

public class UpdateEmployeeBenefitFeedProcessExecutor extends SupplierProcessExecutor<UpdateEmployeeBenefitFeedProcess, EmployeeBenefitFeed> {

    public UpdateEmployeeBenefitFeedProcessExecutor() {
        super(new UpdateEmployeeBenefitFeedProcess(),
                UpdateFieldsParamsEmployeeBenefitFeedRule::new,
                UpdateEmployeeBenefitFeedRule::new
        );
    }

    public static UpdateEmployeeBenefitFeedProcessExecutor builder() {
        return new UpdateEmployeeBenefitFeedProcessExecutor();
    }

}
