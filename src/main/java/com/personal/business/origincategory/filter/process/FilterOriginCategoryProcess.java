package com.personal.business.origincategory.filter.process;

import com.personal.business.origincategory.entities.OriginCategory;
import com.personal.business.origincategory.filter.inputs.FilterOriginCategoryInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterOriginCategoryProcess extends FunctionalProcess<FilterOriginCategoryInput, OriginCategory> {

    public FilterOriginCategoryProcess() {
        super("filter_origin_categories_process");
    }

}
