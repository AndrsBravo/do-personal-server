package com.personal.management.payrollbenefit.factories;

import com.personal.management.payrollbenefit.create.services.CreatePayrollBenefitService;
import com.personal.management.payrollbenefit.delete.services.DeletePayrollBenefitService;
import com.personal.management.payrollbenefit.filter.services.FilterPayrollBenefitService;
import com.personal.management.payrollbenefit.update.services.EditPayrollBenefitService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class PayrollBenefitServiceFactory {

    public static CreatePayrollBenefitService CreatePayrollBenefit() {

        return new CreatePayrollBenefitService(DbClientMSSQLFactory.Management());
    }

    public static FilterPayrollBenefitService FilterPayrollBenefit() {

        return new FilterPayrollBenefitService(DbClientMSSQLFactory.Management());
    }

    public static EditPayrollBenefitService EditPayrollBenefit() {

        return new EditPayrollBenefitService(DbClientMSSQLFactory.Management());
    }

    public static DeletePayrollBenefitService DeletePayrollBenefit() {

        return new DeletePayrollBenefitService(DbClientMSSQLFactory.Management());
    }

}
