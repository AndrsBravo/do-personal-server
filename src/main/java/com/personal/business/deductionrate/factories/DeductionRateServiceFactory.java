package com.personal.business.deductionrate.factories;

import com.personal.business.deductionrate.create.services.CreateDeductionRateService;
import com.personal.business.deductionrate.delete.services.DeleteDeductionRateService;
import com.personal.business.deductionrate.filter.services.FilterDeductionRateService;
import com.personal.business.deductionrate.update.services.EditDeductionRateService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class DeductionRateServiceFactory {

    public static CreateDeductionRateService CreateDeductionRate(String dbClient) {

        return new CreateDeductionRateService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static FilterDeductionRateService FilterDeductionRate(String dbClient) {

        return new FilterDeductionRateService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static EditDeductionRateService EditDeductionRate(String dbClient) {

        return new EditDeductionRateService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static DeleteDeductionRateService DeleteDeductionRate(String dbClient) {

        return new DeleteDeductionRateService(DbClientMSSQLFactory.DbClient(dbClient));
    }

}
