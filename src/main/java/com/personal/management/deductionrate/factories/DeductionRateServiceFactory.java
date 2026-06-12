package com.personal.management.deductionrate.factories;

import com.personal.management.deductionrate.create.services.CreateDeductionRateService;
import com.personal.management.deductionrate.delete.services.DeleteDeductionRateService;
import com.personal.management.deductionrate.filter.services.FilterDeductionRateService;
import com.personal.management.deductionrate.update.services.EditDeductionRateService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class DeductionRateServiceFactory {

    public static CreateDeductionRateService CreateDeductionRate() {

        return new CreateDeductionRateService(DbClientMSSQLFactory.Management());
    }

    public static FilterDeductionRateService FilterDeductionRate() {

        return new FilterDeductionRateService(DbClientMSSQLFactory.Management());
    }

    public static EditDeductionRateService EditDeductionRate() {

        return new EditDeductionRateService(DbClientMSSQLFactory.Management());
    }

    public static DeleteDeductionRateService DeleteDeductionRate() {

        return new DeleteDeductionRateService(DbClientMSSQLFactory.Management());
    }

}
