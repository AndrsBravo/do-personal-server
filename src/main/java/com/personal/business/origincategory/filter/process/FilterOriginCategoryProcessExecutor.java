package com.personal.business.origincategory.filter.process;

import com.personal.business.origincategory.entities.OriginCategory;
import com.personal.business.origincategory.filter.inputs.FilterOriginCategoryInput;
import com.personal.business.origincategory.filter.process.rules.FilterOriginCategoryRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterOriginCategoryProcessExecutor extends FunctionalProcessExecutor<FilterOriginCategoryProcess, FilterOriginCategoryInput, OriginCategory> {

    public FilterOriginCategoryProcessExecutor() {
        super(new FilterOriginCategoryProcess(), FilterOriginCategoryRule::new);
    }

    public static FilterOriginCategoryProcessExecutor builder() {
        return new FilterOriginCategoryProcessExecutor();
    }

}
