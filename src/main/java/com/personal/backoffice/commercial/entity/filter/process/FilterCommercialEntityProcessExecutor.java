package com.personal.backoffice.commercial.entity.filter.process;

import com.personal.backoffice.commercial.entity.entities.CommercialEntity;
import com.personal.backoffice.commercial.entity.filter.inputs.FilterCommercialEntityInput;
import com.personal.backoffice.commercial.entity.filter.process.rules.FilterCommercialEntityRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterCommercialEntityProcessExecutor extends FunctionalProcessExecutor<FilterCommercialEntityProcess, FilterCommercialEntityInput, CommercialEntity> {

    public FilterCommercialEntityProcessExecutor() {
        super(new FilterCommercialEntityProcess(), FilterCommercialEntityRule::new);
    }

    public static FilterCommercialEntityProcessExecutor builder() {
        return new FilterCommercialEntityProcessExecutor();
    }

}
