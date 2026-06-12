package com.personal.business.hierarchybenefit.delete.process;

import com.personal.business.hierarchybenefit.delete.process.rules.DeleteHierarchyBenefitRule;
import com.personal.business.hierarchybenefit.entities.HierarchyBenefit;
import com.personal.shared.process.SupplierProcessExecutor;

public class DeleteHierarchyBenefitProcessExecutor extends SupplierProcessExecutor<DeleteHierarchyBenefitProcess, HierarchyBenefit> {

    public DeleteHierarchyBenefitProcessExecutor() {
        super(new DeleteHierarchyBenefitProcess(),
                DeleteHierarchyBenefitRule::new
        );
    }

    public static DeleteHierarchyBenefitProcessExecutor builder() {
        return new DeleteHierarchyBenefitProcessExecutor();
    }

}
