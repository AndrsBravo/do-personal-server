package com.personal.business.hierarchybenefit.update.process;

import com.personal.business.hierarchybenefit.entities.HierarchyBenefit;
import com.personal.business.hierarchybenefit.update.process.rules.UpdateHierarchyBenefitRule;
import com.personal.business.hierarchybenefit.update.process.rules.UpdateFieldsParamsHierarchyBenefitRule;
import com.personal.shared.process.SupplierProcessExecutor;

public class UpdateHierarchyBenefitProcessExecutor extends SupplierProcessExecutor<UpdateHierarchyBenefitProcess, HierarchyBenefit> {

    public UpdateHierarchyBenefitProcessExecutor() {
        super(new UpdateHierarchyBenefitProcess(),
                UpdateFieldsParamsHierarchyBenefitRule::new,
                UpdateHierarchyBenefitRule::new
        );
    }

    public static UpdateHierarchyBenefitProcessExecutor builder() {
        return new UpdateHierarchyBenefitProcessExecutor();
    }

}
