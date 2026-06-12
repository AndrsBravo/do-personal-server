package com.personal.business.payrollcalculationresult.factories;

import com.personal.business.payrollcalculationresult.create.services.CreatePayrollCalculationResultService;
import com.personal.business.payrollcalculationresult.delete.services.DeletePayrollCalculationResultService;
import com.personal.business.payrollcalculationresult.filter.services.FilterPayrollCalculationResultService;
import com.personal.business.payrollcalculationresult.update.services.EditPayrollCalculationResultService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class PayrollCalculationResultServiceFactory {

    public static CreatePayrollCalculationResultService CreatePayrollCalculationResult(String dbClient) {

        return new CreatePayrollCalculationResultService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static FilterPayrollCalculationResultService FilterPayrollCalculationResult(String dbClient) {

        return new FilterPayrollCalculationResultService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static EditPayrollCalculationResultService EditPayrollCalculationResult(String dbClient) {

        return new EditPayrollCalculationResultService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static DeletePayrollCalculationResultService DeletePayrollCalculationResult(String dbClient) {

        return new DeletePayrollCalculationResultService(DbClientMSSQLFactory.DbClient(dbClient));
    }

}
