package com.personal.business.payrollcalculationresult.factories;

import java.util.List;

import com.personal.business.payrollcalculationresult.entities.PayrollCalculationResult;
import com.personal.business.payrollcalculationresult.notifications.PayrollCalculationResultNotificationFactory;
import com.personal.shared.services.entities.ServiceResult;

public class PayrollCalculationResultResultFactory {

    public static ServiceResult<PayrollCalculationResult> CreateFail() {
        return new ServiceResult<>(PayrollCalculationResultNotificationFactory.CreatePayrollCalculationResultFail(), null);
    }

    public static ServiceResult<PayrollCalculationResult> CreateSuccess(PayrollCalculationResult payroll) {
        return new ServiceResult<>(null, payroll);
    }

    public static ServiceResult<PayrollCalculationResult> UpdateFail() {
        return new ServiceResult<>(PayrollCalculationResultNotificationFactory.UpdatePayrollCalculationResultFail(), null);
    }

    public static ServiceResult<PayrollCalculationResult> UpdateSuccess(PayrollCalculationResult payroll) {
        return new ServiceResult<>(null, payroll);
    }

    public static ServiceResult<PayrollCalculationResult> DeleteSuccess(PayrollCalculationResult payroll) {
        return new ServiceResult<>(null, payroll);
    }

    public static ServiceResult<PayrollCalculationResult> DeleteFail() {
        return new ServiceResult<>(PayrollCalculationResultNotificationFactory.DeletePayrollCalculationResultFail(), null);
    }

    public static ServiceResult<List<PayrollCalculationResult>> FetchNull() {
        return new ServiceResult<>(PayrollCalculationResultNotificationFactory.FetchNull(), null);
    }

    public static ServiceResult<List<PayrollCalculationResult>> FetchResult(List<PayrollCalculationResult> payroll) {
        return new ServiceResult<>(null, payroll);
    }

}
