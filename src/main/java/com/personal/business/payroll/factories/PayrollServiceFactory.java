package com.personal.business.payroll.factories;

import com.personal.business.payroll.create.services.CreatePayrollService;
import com.personal.business.payroll.delete.services.DeletePayrollService;
import com.personal.business.payroll.filter.services.FilterPayrollService;
import com.personal.business.payroll.update.services.EditPayrollService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class PayrollServiceFactory {

    public static CreatePayrollService CreatePayroll(String dbClient) {

        return new CreatePayrollService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static FilterPayrollService FilterPayroll(String dbClient) {

        return new FilterPayrollService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static EditPayrollService EditPayroll(String dbClient) {

        return new EditPayrollService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static DeletePayrollService DeletePayroll(String dbClient) {

        return new DeletePayrollService(DbClientMSSQLFactory.DbClient(dbClient));
    }

}
