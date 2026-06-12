package com.personal.business.payroll.factories;

import java.util.List;

import com.personal.business.payroll.entities.Payroll;
import com.personal.business.payroll.notifications.PayrollNotificationFactory;
import com.personal.shared.services.ServiceResult;

public class PayrollResultFactory {

    public static ServiceResult<Payroll> CreateFail() {
        return new ServiceResult<>(PayrollNotificationFactory.CreatePayrollFail(), null);
    }

    public static ServiceResult<Payroll> CreateSuccess(Payroll payroll) {
        return new ServiceResult<>(null, payroll);
    }

    public static ServiceResult<Payroll> UpdateFail() {
        return new ServiceResult<>(PayrollNotificationFactory.UpdatePayrollFail(), null);
    }

    public static ServiceResult<Payroll> UpdateSuccess(Payroll payroll) {
        return new ServiceResult<>(null, payroll);
    }

    public static ServiceResult<Payroll> DeleteSuccess(Payroll payroll) {
        return new ServiceResult<>(null, payroll);
    }

    public static ServiceResult<Payroll> DeleteFail() {
        return new ServiceResult<>(PayrollNotificationFactory.DeletePayrollFail(), null);
    }

    public static ServiceResult<List<Payroll>> FetchNull() {
        return new ServiceResult<>(PayrollNotificationFactory.FetchNull(), null);
    }

    public static ServiceResult<List<Payroll>> FetchResult(List<Payroll> payroll) {
        return new ServiceResult<>(null, payroll);
    }

}
