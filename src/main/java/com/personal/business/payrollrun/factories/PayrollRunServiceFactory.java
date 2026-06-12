package com.personal.business.payrollrun.factories;

import com.personal.business.payrollrun.create.services.CreatePayrollRunService;
import com.personal.business.payrollrun.delete.services.DeletePayrollRunService;
import com.personal.business.payrollrun.filter.services.FilterPayrollRunService;
import com.personal.business.payrollrun.update.services.EditPayrollRunService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class PayrollRunServiceFactory {

    public static CreatePayrollRunService CreatePayrollRun(String dbClient) {

        return new CreatePayrollRunService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static FilterPayrollRunService FilterPayrollRun(String dbClient) {

        return new FilterPayrollRunService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static EditPayrollRunService EditPayrollRun(String dbClient) {

        return new EditPayrollRunService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static DeletePayrollRunService DeletePayrollRun(String dbClient) {

        return new DeletePayrollRunService(DbClientMSSQLFactory.DbClient(dbClient));
    }

}
