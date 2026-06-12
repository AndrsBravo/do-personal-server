package com.personal.business.payrolldeduction.factories;

import com.personal.business.payrolldeduction.create.services.CreatePayrollDeductionService;
import com.personal.business.payrolldeduction.delete.services.DeletePayrollDeductionService;
import com.personal.business.payrolldeduction.filter.services.FilterPayrollDeductionService;
import com.personal.business.payrolldeduction.update.services.EditPayrollDeductionService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class PayrollDeductionServiceFactory {

    public static CreatePayrollDeductionService CreatePayrollDeduction(String dbClient) {

        return new CreatePayrollDeductionService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static FilterPayrollDeductionService FilterPayrollDeduction(String dbClient) {

        return new FilterPayrollDeductionService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static EditPayrollDeductionService EditPayrollDeduction(String dbClient) {

        return new EditPayrollDeductionService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static DeletePayrollDeductionService DeletePayrollDeduction(String dbClient) {

        return new DeletePayrollDeductionService(DbClientMSSQLFactory.DbClient(dbClient));
    }

}
