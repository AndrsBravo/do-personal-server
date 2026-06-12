package com.personal.business.payrollemployee.factories;

import com.personal.business.payrollemployee.create.services.CreatePayrollEmployeeService;
import com.personal.business.payrollemployee.delete.services.DeletePayrollEmployeeService;
import com.personal.business.payrollemployee.filter.services.FilterPayrollEmployeeService;
import com.personal.business.payrollemployee.update.services.EditPayrollEmployeeService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class PayrollEmployeeServiceFactory {

    public static CreatePayrollEmployeeService CreatePayrollEmployee(String dbClient) {

        return new CreatePayrollEmployeeService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static FilterPayrollEmployeeService FilterPayrollEmployee(String dbClient) {

        return new FilterPayrollEmployeeService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static EditPayrollEmployeeService EditPayrollEmployee(String dbClient) {

        return new EditPayrollEmployeeService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static DeletePayrollEmployeeService DeletePayrollEmployee(String dbClient) {

        return new DeletePayrollEmployeeService(DbClientMSSQLFactory.DbClient(dbClient));
    }

}
