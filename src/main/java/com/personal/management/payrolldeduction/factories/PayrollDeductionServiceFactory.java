package com.personal.management.payrolldeduction.factories;

import com.personal.management.payrolldeduction.create.services.CreatePayrollDeductionService;
import com.personal.management.payrolldeduction.delete.services.DeletePayrollDeductionService;
import com.personal.management.payrolldeduction.filter.services.FilterPayrollDeductionService;
import com.personal.management.payrolldeduction.update.services.EditPayrollDeductionService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class PayrollDeductionServiceFactory {

    public static CreatePayrollDeductionService CreatePayrollDeduction() {

        return new CreatePayrollDeductionService(DbClientMSSQLFactory.Management());
    }

    public static FilterPayrollDeductionService FilterPayrollDeduction() {

        return new FilterPayrollDeductionService(DbClientMSSQLFactory.Management());
    }

    public static EditPayrollDeductionService EditPayrollDeduction() {

        return new EditPayrollDeductionService(DbClientMSSQLFactory.Management());
    }

    public static DeletePayrollDeductionService DeletePayrollDeduction() {

        return new DeletePayrollDeductionService(DbClientMSSQLFactory.Management());
    }

}
