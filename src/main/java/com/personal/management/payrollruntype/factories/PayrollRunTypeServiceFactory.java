package com.personal.management.payrollruntype.factories;

import com.personal.management.payrollruntype.create.services.CreatePayrollRunTypeService;
import com.personal.management.payrollruntype.delete.services.DeletePayrollRunTypeService;
import com.personal.management.payrollruntype.filter.services.FilterPayrollRunTypeService;
import com.personal.management.payrollruntype.update.services.EditPayrollRunTypeService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class PayrollRunTypeServiceFactory {

    public static CreatePayrollRunTypeService CreatePayrollRunType() {

        return new CreatePayrollRunTypeService(DbClientMSSQLFactory.Management());
    }

    public static FilterPayrollRunTypeService FilterPayrollRunType() {

        return new FilterPayrollRunTypeService(DbClientMSSQLFactory.Management());
    }

    public static EditPayrollRunTypeService EditPayrollRunType() {

        return new EditPayrollRunTypeService(DbClientMSSQLFactory.Management());
    }

    public static DeletePayrollRunTypeService DeletePayrollRunType() {

        return new DeletePayrollRunTypeService(DbClientMSSQLFactory.Management());
    }

}
