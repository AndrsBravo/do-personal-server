package com.personal.business.structure.filter.process;

import com.personal.business.structure.entities.Structure;
import com.personal.business.structure.filter.inputs.FilterStructureInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterStructureProcess extends FunctionalProcess<FilterStructureInput, Structure> {

    public FilterStructureProcess() {
        super("filter_org_structure");
    }

}
