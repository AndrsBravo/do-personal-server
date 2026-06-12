package com.personal.business.payrollrundeduction.factories;

import java.util.List;

import com.personal.business.payrollrundeduction.entities.PayrollRunDeduction;
import com.personal.business.payrollrundeduction.notifications.PayrollRunDeductionNotificationFactory;
import com.personal.shared.services.ServiceResult;

public class PayrollRunDeductionResultFactory {

    public static ServiceResult<PayrollRunDeduction> CreateFail() {
        return new ServiceResult<>(PayrollRunDeductionNotificationFactory.CreatePayrollRunDeductionFail(), null);
    }

    public static ServiceResult<PayrollRunDeduction> CreateSuccess(PayrollRunDeduction payrollRunDeduction) {
        return new ServiceResult<>(null, payrollRunDeduction);
    }

    public static ServiceResult<PayrollRunDeduction> UpdateFail() {
        return new ServiceResult<>(PayrollRunDeductionNotificationFactory.UpdatePayrollRunDeductionFail(), null);
    }

    public static ServiceResult<PayrollRunDeduction> UpdateSuccess(PayrollRunDeduction payrollRunDeduction) {
        return new ServiceResult<>(null, payrollRunDeduction);
    }

    public static ServiceResult<PayrollRunDeduction> DeleteSuccess(PayrollRunDeduction payrollRunDeduction) {
        return new ServiceResult<>(null, payrollRunDeduction);
    }

    public static ServiceResult<PayrollRunDeduction> DeleteFail() {
        return new ServiceResult<>(PayrollRunDeductionNotificationFactory.DeletePayrollRunDeductionFail(), null);
    }

    public static ServiceResult<List<PayrollRunDeduction>> FetchNull() {
        return new ServiceResult<>(PayrollRunDeductionNotificationFactory.FetchNull(), null);
    }

    public static ServiceResult<List<PayrollRunDeduction>> FetchResult(List<PayrollRunDeduction> payrollRunDeduction) {
        return new ServiceResult<>(null, payrollRunDeduction);
    }

}
