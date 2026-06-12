package com.personal.business.payrollrunresult.factories;

import java.util.List;

import com.personal.business.payrollrunresult.entities.PayrollRunResult;
import com.personal.business.payrollrunresult.notifications.PayrollRunResultNotificationFactory;
import com.personal.shared.services.ServiceResult;

public class PayrollRunResultResultFactory {

    public static ServiceResult<PayrollRunResult> CreateFail() {
        return new ServiceResult<>(PayrollRunResultNotificationFactory.CreatePayrollRunResultFail(), null);
    }

    public static ServiceResult<PayrollRunResult> CreateSuccess(PayrollRunResult payroll) {
        return new ServiceResult<>(null, payroll);
    }

    public static ServiceResult<PayrollRunResult> UpdateFail() {
        return new ServiceResult<>(PayrollRunResultNotificationFactory.UpdatePayrollRunResultFail(), null);
    }

    public static ServiceResult<PayrollRunResult> UpdateSuccess(PayrollRunResult payroll) {
        return new ServiceResult<>(null, payroll);
    }

    public static ServiceResult<PayrollRunResult> DeleteSuccess(PayrollRunResult payroll) {
        return new ServiceResult<>(null, payroll);
    }

    public static ServiceResult<PayrollRunResult> DeleteFail() {
        return new ServiceResult<>(PayrollRunResultNotificationFactory.DeletePayrollRunResultFail(), null);
    }

    public static ServiceResult<List<PayrollRunResult>> FetchNull() {
        return new ServiceResult<>(PayrollRunResultNotificationFactory.FetchNull(), null);
    }

    public static ServiceResult<List<PayrollRunResult>> FetchResult(List<PayrollRunResult> payroll) {
        return new ServiceResult<>(null, payroll);
    }

}
