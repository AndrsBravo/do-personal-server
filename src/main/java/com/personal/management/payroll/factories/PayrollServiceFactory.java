package com.personal.management.payroll.factories;

import com.personal.management.payroll.create.services.CreatePayrollService;
import com.personal.management.payroll.delete.services.DeletePayrollService;
import com.personal.management.payroll.filter.services.FilterPayrollService;
import com.personal.management.payroll.update.services.EditPayrollService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class PayrollServiceFactory {

    public static CreatePayrollService CreatePayroll() {

        return new CreatePayrollService(DbClientMSSQLFactory.Management());
    }

    public static FilterPayrollService FilterPayroll() {

        return new FilterPayrollService(DbClientMSSQLFactory.Management());
    }

    public static EditPayrollService EditPayroll() {

        return new EditPayrollService(DbClientMSSQLFactory.Management());
    }

    public static DeletePayrollService DeletePayroll() {

        return new DeletePayrollService(DbClientMSSQLFactory.Management());
    }

}
