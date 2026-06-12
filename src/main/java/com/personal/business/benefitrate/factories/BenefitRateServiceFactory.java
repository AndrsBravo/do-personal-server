package com.personal.business.benefitrate.factories;

import com.personal.business.benefitrate.create.services.CreateBenefitRateService;
import com.personal.business.benefitrate.delete.services.DeleteBenefitRateService;
import com.personal.business.benefitrate.filter.services.FilterBenefitRateService;
import com.personal.business.benefitrate.update.services.EditBenefitRateService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class BenefitRateServiceFactory {

    public static CreateBenefitRateService CreateBenefitRate(String dbClient) {

        return new CreateBenefitRateService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static FilterBenefitRateService FilterBenefitRate(String dbClient) {

        return new FilterBenefitRateService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static EditBenefitRateService EditBenefitRate(String dbClient) {

        return new EditBenefitRateService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static DeleteBenefitRateService DeleteBenefitRate(String dbClient) {

        return new DeleteBenefitRateService(DbClientMSSQLFactory.DbClient(dbClient));
    }

}
