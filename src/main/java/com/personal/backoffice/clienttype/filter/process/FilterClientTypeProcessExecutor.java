package com.personal.backoffice.clienttype.filter.process;

import com.personal.backoffice.clienttype.filter.process.rules.FilterClientTypeRule;
import com.personal.shared.entities.TypeEntityBase;
import com.personal.shared.inputs.FilterTypeInput;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterClientTypeProcessExecutor extends FunctionalProcessExecutor<FilterClientTypeProcess, FilterTypeInput, TypeEntityBase> {

    public FilterClientTypeProcessExecutor() {
        super(new FilterClientTypeProcess(), FilterClientTypeRule::new);
    }

    public static FilterClientTypeProcessExecutor builder() {
        return new FilterClientTypeProcessExecutor();
    }

}
