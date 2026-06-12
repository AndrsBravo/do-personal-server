package com.personal.backoffice.commercial.entity.filter.process;

import com.personal.backoffice.commercial.entity.entities.CommercialEntity;
import com.personal.backoffice.commercial.entity.filter.inputs.FilterCommercialEntityInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterCommercialEntityProcess extends FunctionalProcess<FilterCommercialEntityInput, CommercialEntity> {

    public FilterCommercialEntityProcess() {
        super("filter_commercial_entity");
    }

}
