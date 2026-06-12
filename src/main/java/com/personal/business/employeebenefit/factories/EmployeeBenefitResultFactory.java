package com.personal.business.employeebenefit.factories;

import java.util.List;

import com.personal.business.employeebenefit.entities.EmployeeBenefit;
import com.personal.business.employeebenefit.notifications.EmployeeBenefitNotificationFactory;
import com.personal.shared.services.ServiceResult;

public class EmployeeBenefitResultFactory {

    public static ServiceResult<EmployeeBenefit> CreateFail() {
        return new ServiceResult<>(EmployeeBenefitNotificationFactory.CreateEmployeeBenefitFail(), null);
    }

    public static ServiceResult<EmployeeBenefit> CreateSuccess(EmployeeBenefit employeeBenefit) {
        return new ServiceResult<>(null, employeeBenefit);
    }

    public static ServiceResult<EmployeeBenefit> UpdateFail() {
        return new ServiceResult<>(EmployeeBenefitNotificationFactory.UpdateEmployeeBenefitFail(), null);
    }

    public static ServiceResult<EmployeeBenefit> UpdateSuccess(EmployeeBenefit employeeBenefit) {
        return new ServiceResult<>(null, employeeBenefit);
    }

    public static ServiceResult<EmployeeBenefit> DeleteSuccess(EmployeeBenefit employeeBenefit) {
        return new ServiceResult<>(null, employeeBenefit);
    }

    public static ServiceResult<EmployeeBenefit> DeleteFail() {
        return new ServiceResult<>(EmployeeBenefitNotificationFactory.DeleteEmployeeBenefitFail(), null);
    }

    public static ServiceResult<List<EmployeeBenefit>> FetchNull() {
        return new ServiceResult<>(EmployeeBenefitNotificationFactory.FetchNull(), null);
    }

    public static ServiceResult<List<EmployeeBenefit>> FetchResult(List<EmployeeBenefit> employeeBenefit) {
        return new ServiceResult<>(null, employeeBenefit);
    }

}
