package com.personal.backoffice.usertype.filter.process;

import com.personal.shared.entities.TypeEntityBase;
import com.personal.shared.inputs.FilterTypeInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterUserTypeProcess extends FunctionalProcess<FilterTypeInput, TypeEntityBase> {

    public FilterUserTypeProcess() {
        super("filter_user_types");
    }

}
