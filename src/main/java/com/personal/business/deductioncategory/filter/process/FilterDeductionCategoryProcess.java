package com.personal.business.deductioncategory.filter.process;

import com.personal.business.deductioncategory.entities.DeductionCategory;
import com.personal.business.deductioncategory.filter.inputs.FilterDeductionCategoryInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterDeductionCategoryProcess extends FunctionalProcess<FilterDeductionCategoryInput, DeductionCategory> {

    public FilterDeductionCategoryProcess() {
        super("filter_deductions_category");
    }

}
