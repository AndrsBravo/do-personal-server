package com.personal.management.payrollrundeduction.factories;

import com.personal.management.payrollrundeduction.create.services.CreatePayrollRunDeductionService;
import com.personal.management.payrollrundeduction.delete.services.DeletePayrollRunDeductionService;
import com.personal.management.payrollrundeduction.filter.services.FilterPayrollRunDeductionService;
import com.personal.management.payrollrundeduction.update.services.EditPayrollRunDeductionService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class PayrollRunDeductionServiceFactory {

    public static CreatePayrollRunDeductionService CreatePayrollRunDeduction() {

        return new CreatePayrollRunDeductionService(DbClientMSSQLFactory.Management());
    }

    public static FilterPayrollRunDeductionService FilterPayrollRunDeduction() {

        return new FilterPayrollRunDeductionService(DbClientMSSQLFactory.Management());
    }

    public static EditPayrollRunDeductionService EditPayrollRunDeduction() {

        return new EditPayrollRunDeductionService(DbClientMSSQLFactory.Management());
    }

    public static DeletePayrollRunDeductionService DeletePayrollRunDeduction() {

        return new DeletePayrollRunDeductionService(DbClientMSSQLFactory.Management());
    }

}
