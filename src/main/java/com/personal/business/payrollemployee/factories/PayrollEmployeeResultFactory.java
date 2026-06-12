package com.personal.business.payrollemployee.factories;

import java.util.List;

import com.personal.business.payrollemployee.entities.PayrollEmployee;
import com.personal.business.payrollemployee.notifications.PayrollEmployeeNotificationFactory;
import com.personal.shared.services.ServiceResult;

public class PayrollEmployeeResultFactory {

    public static ServiceResult<PayrollEmployee> CreateFail() {
        return new ServiceResult<>(PayrollEmployeeNotificationFactory.CreatePayrollEmployeeFail(), null);
    }

    public static ServiceResult<PayrollEmployee> CreateSuccess(PayrollEmployee payrollEmployee) {
        return new ServiceResult<>(null, payrollEmployee);
    }

    public static ServiceResult<PayrollEmployee> UpdateFail() {
        return new ServiceResult<>(PayrollEmployeeNotificationFactory.UpdatePayrollEmployeeFail(), null);
    }

    public static ServiceResult<PayrollEmployee> UpdateSuccess(PayrollEmployee payrollEmployee) {
        return new ServiceResult<>(null, payrollEmployee);
    }

    public static ServiceResult<PayrollEmployee> DeleteSuccess(PayrollEmployee payrollEmployee) {
        return new ServiceResult<>(null, payrollEmployee);
    }

    public static ServiceResult<PayrollEmployee> DeleteFail() {
        return new ServiceResult<>(PayrollEmployeeNotificationFactory.DeletePayrollEmployeeFail(), null);
    }

    public static ServiceResult<List<PayrollEmployee>> FetchNull() {
        return new ServiceResult<>(PayrollEmployeeNotificationFactory.FetchNull(), null);
    }

    public static ServiceResult<List<PayrollEmployee>> FetchResult(List<PayrollEmployee> payrollEmployee) {
        return new ServiceResult<>(null, payrollEmployee);
    }

}
