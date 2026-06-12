package com.personal.management.deductioncategory.filter.process;

import com.personal.management.deductioncategory.entities.DeductionCategory;
import com.personal.management.deductioncategory.filter.inputs.FilterDeductionCategoryInput;
import com.personal.management.deductioncategory.filter.process.rules.FilterDeductionCategoryRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterDeductionCategoryProcessExecutor extends FunctionalProcessExecutor<FilterDeductionCategoryProcess, FilterDeductionCategoryInput, DeductionCategory> {

    public FilterDeductionCategoryProcessExecutor() {
        super(new FilterDeductionCategoryProcess(), FilterDeductionCategoryRule::new);
    }

    public static FilterDeductionCategoryProcessExecutor builder() {
        return new FilterDeductionCategoryProcessExecutor();
    }

}
