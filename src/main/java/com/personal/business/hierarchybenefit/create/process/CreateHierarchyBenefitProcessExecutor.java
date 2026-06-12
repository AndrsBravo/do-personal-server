package com.personal.business.hierarchybenefit.create.process;

import com.personal.business.hierarchybenefit.create.process.rules.CreateHierarchyBenefitRule;
import com.personal.business.hierarchybenefit.create.process.rules.ValidateHierarchyBenefitRule;
import com.personal.business.hierarchybenefit.entities.HierarchyBenefit;
import com.personal.shared.process.SupplierProcessExecutor;

public class CreateHierarchyBenefitProcessExecutor extends SupplierProcessExecutor<CreateHierarchyBenefitProcess, HierarchyBenefit> {

    public CreateHierarchyBenefitProcessExecutor() {
        super(new CreateHierarchyBenefitProcess(),
                ValidateHierarchyBenefitRule::new,
                CreateHierarchyBenefitRule::new
        );
    }

    public static CreateHierarchyBenefitProcessExecutor builder() {
        return new CreateHierarchyBenefitProcessExecutor();
    }

}
