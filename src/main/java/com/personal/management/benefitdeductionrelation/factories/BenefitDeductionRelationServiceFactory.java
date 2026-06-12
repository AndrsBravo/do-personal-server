package com.personal.management.benefitdeductionrelation.factories;

import com.personal.management.benefitdeductionrelation.create.services.CreateBenefitDeductionRelationService;
import com.personal.management.benefitdeductionrelation.delete.services.DeleteBenefitDeductionRelationService;
import com.personal.management.benefitdeductionrelation.filter.services.FilterBenefitDeductionRelationService;
import com.personal.management.benefitdeductionrelation.update.services.EditBenefitDeductionRelationService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class BenefitDeductionRelationServiceFactory {

    public static CreateBenefitDeductionRelationService CreateBenefitDeductionRelation() {

        return new CreateBenefitDeductionRelationService(DbClientMSSQLFactory.Management());
    }

    public static FilterBenefitDeductionRelationService FilterBenefitDeductionRelation() {

        return new FilterBenefitDeductionRelationService(DbClientMSSQLFactory.Management());
    }

    public static EditBenefitDeductionRelationService EditBenefitDeductionRelation() {

        return new EditBenefitDeductionRelationService(DbClientMSSQLFactory.Management());
    }

    public static DeleteBenefitDeductionRelationService DeleteBenefitDeductionRelation() {

        return new DeleteBenefitDeductionRelationService(DbClientMSSQLFactory.Management());
    }

}
