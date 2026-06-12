package com.personal.management.deduction.factories;

import com.personal.management.deduction.create.services.CreateDeductionService;
import com.personal.management.deduction.delete.services.DeleteDeductionService;
import com.personal.management.deduction.filter.services.FilterDeductionService;
import com.personal.management.deduction.update.services.EditDeductionService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class DeductionServiceFactory {

    public static CreateDeductionService CreateDeduction() {

        return new CreateDeductionService(DbClientMSSQLFactory.Management());
    }

    public static FilterDeductionService FilterDeduction() {

        return new FilterDeductionService(DbClientMSSQLFactory.Management());
    }

    public static EditDeductionService EditDeduction() {

        return new EditDeductionService(DbClientMSSQLFactory.Management());
    }

    public static DeleteDeductionService DeleteDeduction() {

        return new DeleteDeductionService(DbClientMSSQLFactory.Management());
    }

}
