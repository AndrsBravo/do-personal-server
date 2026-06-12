package com.personal.business.payrollrunbenefit.factories;

import com.personal.business.payrollrunbenefit.create.services.CreatePayrollRunBenefitService;
import com.personal.business.payrollrunbenefit.delete.services.DeletePayrollRunBenefitService;
import com.personal.business.payrollrunbenefit.filter.services.FilterPayrollRunBenefitService;
import com.personal.business.payrollrunbenefit.update.services.EditPayrollRunBenefitService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class PayrollRunBenefitServiceFactory {

    public static CreatePayrollRunBenefitService CreatePayrollRunBenefit(String dbClient) {

        return new CreatePayrollRunBenefitService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static FilterPayrollRunBenefitService FilterPayrollRunBenefit(String dbClient) {

        return new FilterPayrollRunBenefitService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static EditPayrollRunBenefitService EditPayrollRunBenefit(String dbClient) {

        return new EditPayrollRunBenefitService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static DeletePayrollRunBenefitService DeletePayrollRunBenefit(String dbClient) {

        return new DeletePayrollRunBenefitService(DbClientMSSQLFactory.DbClient(dbClient));
    }

}
