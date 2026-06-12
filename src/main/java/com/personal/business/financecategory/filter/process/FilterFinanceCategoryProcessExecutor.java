package com.personal.business.financecategory.filter.process;

import com.personal.business.financecategory.entities.FinanceCategory;
import com.personal.business.financecategory.filter.inputs.FilterFinanceCategoryInput;
import com.personal.business.financecategory.filter.process.rules.FilterFinanceCategoryRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterFinanceCategoryProcessExecutor extends FunctionalProcessExecutor<FilterFinanceCategoryProcess, FilterFinanceCategoryInput, FinanceCategory> {

    public FilterFinanceCategoryProcessExecutor() {
        super(new FilterFinanceCategoryProcess(), FilterFinanceCategoryRule::new);
    }

    public static FilterFinanceCategoryProcessExecutor builder() {
        return new FilterFinanceCategoryProcessExecutor();
    }

}
