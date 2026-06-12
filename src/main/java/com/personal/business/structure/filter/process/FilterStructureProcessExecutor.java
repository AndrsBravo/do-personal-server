package com.personal.business.structure.filter.process;

import com.personal.business.structure.entities.Structure;
import com.personal.business.structure.filter.inputs.FilterStructureInput;
import com.personal.business.structure.filter.process.rules.FilterStructureRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterStructureProcessExecutor extends FunctionalProcessExecutor<FilterStructureProcess, FilterStructureInput, Structure> {

    public FilterStructureProcessExecutor() {
        super(new FilterStructureProcess(), FilterStructureRule::new);
    }

    public static FilterStructureProcessExecutor builder() {
        return new FilterStructureProcessExecutor();
    }

}
