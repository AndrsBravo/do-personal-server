package com.personal.management.payrollrunbenefit.factories;

import java.util.List;

import com.personal.management.payrollrunbenefit.entities.PayrollRunBenefit;
import com.personal.management.payrollrunbenefit.notifications.PayrollRunBenefitNotificationFactory;
import com.personal.shared.services.ServiceResult;

public class PayrollRunBenefitResultFactory {

    public static ServiceResult<PayrollRunBenefit> CreateFail() {
        return new ServiceResult<>(PayrollRunBenefitNotificationFactory.CreatePayrollRunBenefitFail(), null);
    }

    public static ServiceResult<PayrollRunBenefit> CreateSuccess(PayrollRunBenefit payrollRunBenefit) {
        return new ServiceResult<>(null, payrollRunBenefit);
    }

    public static ServiceResult<PayrollRunBenefit> UpdateFail() {
        return new ServiceResult<>(PayrollRunBenefitNotificationFactory.UpdatePayrollRunBenefitFail(), null);
    }

    public static ServiceResult<PayrollRunBenefit> UpdateSuccess(PayrollRunBenefit payrollRunBenefit) {
        return new ServiceResult<>(null, payrollRunBenefit);
    }

    public static ServiceResult<PayrollRunBenefit> DeleteSuccess(PayrollRunBenefit payrollRunBenefit) {
        return new ServiceResult<>(null, payrollRunBenefit);
    }

    public static ServiceResult<PayrollRunBenefit> DeleteFail() {
        return new ServiceResult<>(PayrollRunBenefitNotificationFactory.DeletePayrollRunBenefitFail(), null);
    }

    public static ServiceResult<List<PayrollRunBenefit>> FetchNull() {
        return new ServiceResult<>(PayrollRunBenefitNotificationFactory.FetchNull(), null);
    }

    public static ServiceResult<List<PayrollRunBenefit>> FetchResult(List<PayrollRunBenefit> payrollRunBenefit) {
        return new ServiceResult<>(null, payrollRunBenefit);
    }

}
