package com.personal.business.employeedeductionfeed.update.process;

import com.personal.business.employeedeductionfeed.entities.EmployeeDeductionFeed;
import com.personal.business.employeedeductionfeed.update.process.rules.UpdateEmployeeDeductionFeedRule;
import com.personal.business.employeedeductionfeed.update.process.rules.UpdateFieldsParamsEmployeeDeductionFeedRule;
import com.personal.shared.process.SupplierProcessExecutor;

public class UpdateEmployeeDeductionFeedProcessExecutor extends SupplierProcessExecutor<UpdateEmployeeDeductionFeedProcess, EmployeeDeductionFeed> {

    public UpdateEmployeeDeductionFeedProcessExecutor() {
        super(new UpdateEmployeeDeductionFeedProcess(),
                UpdateFieldsParamsEmployeeDeductionFeedRule::new,
                UpdateEmployeeDeductionFeedRule::new
        );
    }

    public static UpdateEmployeeDeductionFeedProcessExecutor builder() {
        return new UpdateEmployeeDeductionFeedProcessExecutor();
    }

}
