package com.personal.business.payrollcalculation.factories;

import com.personal.business.payrollcalculation.create.services.CreatePayrollCalculationService;
import com.personal.business.payrollcalculation.delete.services.DeletePayrollCalculationService;
import com.personal.business.payrollcalculation.filter.services.FilterPayrollCalculationService;
import com.personal.business.payrollcalculation.update.services.EditPayrollCalculationService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class PayrollCalculationServiceFactory {

    public static CreatePayrollCalculationService CreatePayrollCalculation(String dbClient) {

        return new CreatePayrollCalculationService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static FilterPayrollCalculationService FilterPayrollCalculation(String dbClient) {

        return new FilterPayrollCalculationService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static EditPayrollCalculationService EditPayrollCalculation(String dbClient) {

        return new EditPayrollCalculationService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static DeletePayrollCalculationService DeletePayrollCalculation(String dbClient) {

        return new DeletePayrollCalculationService(DbClientMSSQLFactory.DbClient(dbClient));
    }

}
