package com.personal.management.financecategory.filter.process;

import com.personal.management.financecategory.entities.FinanceCategory;
import com.personal.management.financecategory.filter.inputs.FilterFinanceCategoryInput;
import com.personal.management.financecategory.filter.process.rules.FilterFinanceCategoryRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterFinanceCategoryProcessExecutor extends FunctionalProcessExecutor<FilterFinanceCategoryProcess, FilterFinanceCategoryInput, FinanceCategory> {

    public FilterFinanceCategoryProcessExecutor() {
        super(new FilterFinanceCategoryProcess(), FilterFinanceCategoryRule::new);
    }

    public static FilterFinanceCategoryProcessExecutor builder() {
        return new FilterFinanceCategoryProcessExecutor();
    }

}
