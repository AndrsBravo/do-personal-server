package com.personal.business.benefitdeductionrelation.factories;

import com.personal.business.benefitdeductionrelation.create.services.CreateBenefitDeductionRelationService;
import com.personal.business.benefitdeductionrelation.delete.services.DeleteBenefitDeductionRelationService;
import com.personal.business.benefitdeductionrelation.filter.services.FilterBenefitDeductionRelationService;
import com.personal.business.benefitdeductionrelation.update.services.EditBenefitDeductionRelationService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class BenefitDeductionRelationServiceFactory {

    public static CreateBenefitDeductionRelationService CreateBenefitDeductionRelation(String dbClient) {

        return new CreateBenefitDeductionRelationService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static FilterBenefitDeductionRelationService FilterBenefitDeductionRelation(String dbClient) {

        return new FilterBenefitDeductionRelationService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static EditBenefitDeductionRelationService EditBenefitDeductionRelation(String dbClient) {

        return new EditBenefitDeductionRelationService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static DeleteBenefitDeductionRelationService DeleteBenefitDeductionRelation(String dbClient) {

        return new DeleteBenefitDeductionRelationService(DbClientMSSQLFactory.DbClient(dbClient));
    }

}
