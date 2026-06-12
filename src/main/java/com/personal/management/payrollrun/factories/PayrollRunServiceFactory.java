package com.personal.management.payrollrun.factories;

import com.personal.management.payrollrun.create.services.CreatePayrollRunService;
import com.personal.management.payrollrun.delete.services.DeletePayrollRunService;
import com.personal.management.payrollrun.filter.services.FilterPayrollRunService;
import com.personal.management.payrollrun.update.services.EditPayrollRunService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class PayrollRunServiceFactory {

    public static CreatePayrollRunService CreatePayrollRun() {

        return new CreatePayrollRunService(DbClientMSSQLFactory.Management());
    }

    public static FilterPayrollRunService FilterPayrollRun() {

        return new FilterPayrollRunService(DbClientMSSQLFactory.Management());
    }

    public static EditPayrollRunService EditPayrollRun() {

        return new EditPayrollRunService(DbClientMSSQLFactory.Management());
    }

    public static DeletePayrollRunService DeletePayrollRun() {

        return new DeletePayrollRunService(DbClientMSSQLFactory.Management());
    }

}
