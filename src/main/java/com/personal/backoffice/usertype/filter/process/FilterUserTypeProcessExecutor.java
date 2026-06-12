package com.personal.backoffice.usertype.filter.process;

import com.personal.backoffice.usertype.filter.process.rules.FilterUserTypeRule;
import com.personal.shared.entities.TypeEntityBase;
import com.personal.shared.inputs.FilterTypeInput;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterUserTypeProcessExecutor extends FunctionalProcessExecutor<FilterUserTypeProcess, FilterTypeInput, TypeEntityBase> {

    public FilterUserTypeProcessExecutor() {
        super(new FilterUserTypeProcess(), FilterUserTypeRule::new);
    }

    public static FilterUserTypeProcessExecutor builder() {
        return new FilterUserTypeProcessExecutor();
    }

}
