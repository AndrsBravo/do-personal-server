package com.personal.business.payrollrunresult.factories;

import com.personal.business.payrollrunresult.create.services.CreatePayrollRunResultService;
import com.personal.business.payrollrunresult.delete.services.DeletePayrollRunResultService;
import com.personal.business.payrollrunresult.filter.services.FilterPayrollRunResultService;
import com.personal.business.payrollrunresult.update.services.EditPayrollRunResultService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class PayrollRunResultServiceFactory {

    public static CreatePayrollRunResultService CreatePayrollRunResult(String dbClient) {

        return new CreatePayrollRunResultService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static FilterPayrollRunResultService FilterPayrollRunResult(String dbClient) {

        return new FilterPayrollRunResultService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static EditPayrollRunResultService EditPayrollRunResult(String dbClient) {

        return new EditPayrollRunResultService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static DeletePayrollRunResultService DeletePayrollRunResult(String dbClient) {

        return new DeletePayrollRunResultService(DbClientMSSQLFactory.DbClient(dbClient));
    }

}
