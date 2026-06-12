package com.personal.business.payrollruntype.factories;

import com.personal.business.payrollruntype.create.services.CreatePayrollRunTypeService;
import com.personal.business.payrollruntype.delete.services.DeletePayrollRunTypeService;
import com.personal.business.payrollruntype.filter.services.FilterPayrollRunTypeService;
import com.personal.business.payrollruntype.update.services.EditPayrollRunTypeService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class PayrollRunTypeServiceFactory {

    public static CreatePayrollRunTypeService CreatePayrollRunType(String dbConnection) {

        return new CreatePayrollRunTypeService(DbClientMSSQLFactory.DbClient(dbConnection));
    }

    public static FilterPayrollRunTypeService FilterPayrollRunType(String dbConnection) {

        return new FilterPayrollRunTypeService(DbClientMSSQLFactory.DbClient(dbConnection));
    }

    public static EditPayrollRunTypeService EditPayrollRunType(String dbConnection) {

        return new EditPayrollRunTypeService(DbClientMSSQLFactory.DbClient(dbConnection));
    }

    public static DeletePayrollRunTypeService DeletePayrollRunType(String dbConnection) {

        return new DeletePayrollRunTypeService(DbClientMSSQLFactory.DbClient(dbConnection));
    }

}
