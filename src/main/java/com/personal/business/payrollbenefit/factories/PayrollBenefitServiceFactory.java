package com.personal.business.payrollbenefit.factories;

import com.personal.business.payrollbenefit.create.services.CreatePayrollBenefitService;
import com.personal.business.payrollbenefit.delete.services.DeletePayrollBenefitService;
import com.personal.business.payrollbenefit.filter.services.FilterPayrollBenefitService;
import com.personal.business.payrollbenefit.update.services.EditPayrollBenefitService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class PayrollBenefitServiceFactory {

    public static CreatePayrollBenefitService CreatePayrollBenefit(String dbClient) {

        return new CreatePayrollBenefitService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static FilterPayrollBenefitService FilterPayrollBenefit(String dbClient) {

        return new FilterPayrollBenefitService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static EditPayrollBenefitService EditPayrollBenefit(String dbClient) {

        return new EditPayrollBenefitService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static DeletePayrollBenefitService DeletePayrollBenefit(String dbClient) {

        return new DeletePayrollBenefitService(DbClientMSSQLFactory.DbClient(dbClient));
    }

}
