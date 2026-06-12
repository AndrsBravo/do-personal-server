package com.personal.business.payrollcalculation.factories;

import java.util.List;

import com.personal.business.payrollcalculation.entities.PayrollCalculation;
import com.personal.business.payrollcalculation.notifications.PayrollCalculationNotificationFactory;
import com.personal.shared.services.ServiceResult;

public class PayrollCalculationResultFactory {

    public static ServiceResult<PayrollCalculation> CreateFail() {
        return new ServiceResult<>(PayrollCalculationNotificationFactory.CreatePayrollCalculationFail(), null);
    }

    public static ServiceResult<PayrollCalculation> CreateSuccess(PayrollCalculation payroll) {
        return new ServiceResult<>(null, payroll);
    }

    public static ServiceResult<PayrollCalculation> UpdateFail() {
        return new ServiceResult<>(PayrollCalculationNotificationFactory.UpdatePayrollCalculationFail(), null);
    }

    public static ServiceResult<PayrollCalculation> UpdateSuccess(PayrollCalculation payroll) {
        return new ServiceResult<>(null, payroll);
    }

    public static ServiceResult<PayrollCalculation> DeleteSuccess(PayrollCalculation payroll) {
        return new ServiceResult<>(null, payroll);
    }

    public static ServiceResult<PayrollCalculation> DeleteFail() {
        return new ServiceResult<>(PayrollCalculationNotificationFactory.DeletePayrollCalculationFail(), null);
    }

    public static ServiceResult<List<PayrollCalculation>> FetchNull() {
        return new ServiceResult<>(PayrollCalculationNotificationFactory.FetchNull(), null);
    }

    public static ServiceResult<List<PayrollCalculation>> FetchResult(List<PayrollCalculation> payroll) {
        return new ServiceResult<>(null, payroll);
    }

}
