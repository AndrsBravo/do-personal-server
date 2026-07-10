package com.personal.management.payrolldeduction.factories;

import java.util.List;

import com.personal.management.payrolldeduction.entities.PayrollDeduction;
import com.personal.management.payrolldeduction.notifications.PayrollDeductionNotificationFactory;
import com.personal.shared.services.entities.ServiceResult;

public class PayrollDeductionResultFactory {

    public static ServiceResult<PayrollDeduction> CreateFail() {
        return new ServiceResult<>(PayrollDeductionNotificationFactory.CreatePayrollDeductionFail(), null);
    }

    public static ServiceResult<PayrollDeduction> CreateSuccess(PayrollDeduction payrollDeduction) {
        return new ServiceResult<>(null, payrollDeduction);
    }

    public static ServiceResult<PayrollDeduction> UpdateFail() {
        return new ServiceResult<>(PayrollDeductionNotificationFactory.UpdatePayrollDeductionFail(), null);
    }

    public static ServiceResult<PayrollDeduction> UpdateSuccess(PayrollDeduction payrollDeduction) {
        return new ServiceResult<>(null, payrollDeduction);
    }

    public static ServiceResult<PayrollDeduction> DeleteSuccess(PayrollDeduction payrollDeduction) {
        return new ServiceResult<>(null, payrollDeduction);
    }

    public static ServiceResult<PayrollDeduction> DeleteFail() {
        return new ServiceResult<>(PayrollDeductionNotificationFactory.DeletePayrollDeductionFail(), null);
    }

    public static ServiceResult<List<PayrollDeduction>> FetchNull() {
        return new ServiceResult<>(PayrollDeductionNotificationFactory.FetchNull(), null);
    }

    public static ServiceResult<List<PayrollDeduction>> FetchResult(List<PayrollDeduction> payrollDeduction) {
        return new ServiceResult<>(null, payrollDeduction);
    }

}
