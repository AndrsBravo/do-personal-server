package com.personal.management.payrollrunbenefit.factories;

import com.personal.management.payrollrunbenefit.create.services.CreatePayrollRunBenefitService;
import com.personal.management.payrollrunbenefit.delete.services.DeletePayrollRunBenefitService;
import com.personal.management.payrollrunbenefit.filter.services.FilterPayrollRunBenefitService;
import com.personal.management.payrollrunbenefit.update.services.EditPayrollRunBenefitService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class PayrollRunBenefitServiceFactory {

    public static CreatePayrollRunBenefitService CreatePayrollRunBenefit() {

        return new CreatePayrollRunBenefitService(DbClientMSSQLFactory.Management());
    }

    public static FilterPayrollRunBenefitService FilterPayrollRunBenefit() {

        return new FilterPayrollRunBenefitService(DbClientMSSQLFactory.Management());
    }

    public static EditPayrollRunBenefitService EditPayrollRunBenefit() {

        return new EditPayrollRunBenefitService(DbClientMSSQLFactory.Management());
    }

    public static DeletePayrollRunBenefitService DeletePayrollRunBenefit() {

        return new DeletePayrollRunBenefitService(DbClientMSSQLFactory.Management());
    }

}
