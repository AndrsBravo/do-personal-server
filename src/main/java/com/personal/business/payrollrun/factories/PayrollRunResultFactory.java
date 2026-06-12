package com.personal.business.payrollrun.factories;

import java.util.List;

import com.personal.business.payrollrun.entities.PayrollRun;
import com.personal.business.payrollrun.notifications.PayrollRunNotificationFactory;
import com.personal.shared.services.ServiceResult;

public class PayrollRunResultFactory {

    public static ServiceResult<PayrollRun> CreateFail() {
        return new ServiceResult<>(PayrollRunNotificationFactory.CreatePayrollRunFail(), null);
    }

    public static ServiceResult<PayrollRun> CreateSuccess(PayrollRun payroll) {
        return new ServiceResult<>(null, payroll);
    }

    public static ServiceResult<PayrollRun> UpdateFail() {
        return new ServiceResult<>(PayrollRunNotificationFactory.UpdatePayrollRunFail(), null);
    }

    public static ServiceResult<PayrollRun> UpdateSuccess(PayrollRun payroll) {
        return new ServiceResult<>(null, payroll);
    }

    public static ServiceResult<PayrollRun> DeleteSuccess(PayrollRun payroll) {
        return new ServiceResult<>(null, payroll);
    }

    public static ServiceResult<PayrollRun> DeleteFail() {
        return new ServiceResult<>(PayrollRunNotificationFactory.DeletePayrollRunFail(), null);
    }

    public static ServiceResult<List<PayrollRun>> FetchNull() {
        return new ServiceResult<>(PayrollRunNotificationFactory.FetchNull(), null);
    }

    public static ServiceResult<List<PayrollRun>> FetchResult(List<PayrollRun> payroll) {
        return new ServiceResult<>(null, payroll);
    }

}
