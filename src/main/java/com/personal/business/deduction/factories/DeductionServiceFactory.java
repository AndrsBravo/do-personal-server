package com.personal.business.deduction.factories;

import com.personal.business.deduction.create.services.CreateDeductionService;
import com.personal.business.deduction.delete.services.DeleteDeductionService;
import com.personal.business.deduction.filter.services.FilterDeductionService;
import com.personal.business.deduction.update.services.EditDeductionService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class DeductionServiceFactory {

    public static CreateDeductionService CreateDeduction(String dbClient) {

        return new CreateDeductionService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static FilterDeductionService FilterDeduction(String dbClient) {

        return new FilterDeductionService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static EditDeductionService EditDeduction(String dbClient) {

        return new EditDeductionService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static DeleteDeductionService DeleteDeduction(String dbClient) {

        return new DeleteDeductionService(DbClientMSSQLFactory.DbClient(dbClient));
    }

}
