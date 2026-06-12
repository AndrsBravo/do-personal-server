package com.personal.business.payrollbenefit.factories;

import java.util.List;

import com.personal.business.payrollbenefit.entities.PayrollBenefit;
import com.personal.business.payrollbenefit.notifications.PayrollBenefitNotificationFactory;
import com.personal.shared.services.ServiceResult;

public class PayrollBenefitResultFactory {

    public static ServiceResult<PayrollBenefit> CreateFail() {
        return new ServiceResult<>(PayrollBenefitNotificationFactory.CreatePayrollBenefitFail(), null);
    }

    public static ServiceResult<PayrollBenefit> CreateSuccess(PayrollBenefit payrollBenefit) {
        return new ServiceResult<>(null, payrollBenefit);
    }

    public static ServiceResult<PayrollBenefit> UpdateFail() {
        return new ServiceResult<>(PayrollBenefitNotificationFactory.UpdatePayrollBenefitFail(), null);
    }

    public static ServiceResult<PayrollBenefit> UpdateSuccess(PayrollBenefit payrollBenefit) {
        return new ServiceResult<>(null, payrollBenefit);
    }

    public static ServiceResult<PayrollBenefit> DeleteSuccess(PayrollBenefit payrollBenefit) {
        return new ServiceResult<>(null, payrollBenefit);
    }

    public static ServiceResult<PayrollBenefit> DeleteFail() {
        return new ServiceResult<>(PayrollBenefitNotificationFactory.DeletePayrollBenefitFail(), null);
    }

    public static ServiceResult<List<PayrollBenefit>> FetchNull() {
        return new ServiceResult<>(PayrollBenefitNotificationFactory.FetchNull(), null);
    }

    public static ServiceResult<List<PayrollBenefit>> FetchResult(List<PayrollBenefit> payrollBenefit) {
        return new ServiceResult<>(null, payrollBenefit);
    }

}
