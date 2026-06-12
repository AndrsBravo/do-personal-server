package com.personal.management.origincategory.filter.process;

import com.personal.management.origincategory.entities.OriginCategory;
import com.personal.management.origincategory.filter.inputs.FilterOriginCategoryInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterOriginCategoryProcess extends FunctionalProcess<FilterOriginCategoryInput, OriginCategory> {

    public FilterOriginCategoryProcess() {
        super("filter_origin_categories_process");
    }

}
