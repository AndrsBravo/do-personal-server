package com.personal.business.benefit.factories;

import com.personal.business.benefit.create.services.CreateBenefitService;
import com.personal.business.benefit.delete.services.DeleteBenefitService;
import com.personal.business.benefit.filter.services.FilterBenefitService;
import com.personal.business.benefit.update.services.EditBenefitService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class BenefitServiceFactory {

    public static CreateBenefitService CreateBenefit(String dbClient) {

        return new CreateBenefitService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static FilterBenefitService FilterBenefit(String dbClient) {

        return new FilterBenefitService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static EditBenefitService EditBenefit(String dbClient) {

        return new EditBenefitService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static DeleteBenefitService DeleteBenefit(String dbClient) {

        return new DeleteBenefitService(DbClientMSSQLFactory.DbClient(dbClient));
    }

}
