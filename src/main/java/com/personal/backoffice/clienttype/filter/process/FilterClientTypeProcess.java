package com.personal.backoffice.clienttype.filter.process;

import com.personal.shared.entities.TypeEntityBase;
import com.personal.shared.inputs.FilterTypeInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterClientTypeProcess extends FunctionalProcess<FilterTypeInput, TypeEntityBase> {

    public FilterClientTypeProcess() {
        super("filter_client_types");
    }

}
