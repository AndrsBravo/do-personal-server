package com.personal.business.payrollrundeduction.factories;

import com.personal.business.payrollrundeduction.create.services.CreatePayrollRunDeductionService;
import com.personal.business.payrollrundeduction.delete.services.DeletePayrollRunDeductionService;
import com.personal.business.payrollrundeduction.filter.services.FilterPayrollRunDeductionService;
import com.personal.business.payrollrundeduction.update.services.EditPayrollRunDeductionService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class PayrollRunDeductionServiceFactory {

    public static CreatePayrollRunDeductionService CreatePayrollRunDeduction(String dbClient) {

        return new CreatePayrollRunDeductionService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static FilterPayrollRunDeductionService FilterPayrollRunDeduction(String dbClient) {

        return new FilterPayrollRunDeductionService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static EditPayrollRunDeductionService EditPayrollRunDeduction(String dbClient) {

        return new EditPayrollRunDeductionService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static DeletePayrollRunDeductionService DeletePayrollRunDeduction(String dbClient) {

        return new DeletePayrollRunDeductionService(DbClientMSSQLFactory.DbClient(dbClient));
    }

}
