package com.personal.business.payrollruntype.factories;

import java.util.List;

import com.personal.business.payrollruntype.notifications.PayrollRunTypeNotificationFactory;
import com.personal.business.shared.entities.TypeEntity;
import com.personal.shared.services.ServiceResult;

public class PayrollRunTypeResultFactory {

    public static ServiceResult<TypeEntity> CreateFail() {
        return new ServiceResult<>(PayrollRunTypeNotificationFactory.CreatePayrollRunTypeFail(), null);
    }

    public static ServiceResult<TypeEntity> CreateSuccess(TypeEntity payrollRunType) {
        return new ServiceResult<>(null, payrollRunType);
    }

    public static ServiceResult<TypeEntity> UpdateFail() {
        return new ServiceResult<>(PayrollRunTypeNotificationFactory.UpdatePayrollRunTypeFail(), null);
    }

    public static ServiceResult<TypeEntity> UpdateSuccess(TypeEntity payrollRunType) {
        return new ServiceResult<>(null, payrollRunType);
    }

    public static ServiceResult<TypeEntity> DeleteSuccess(TypeEntity payrollRunType) {
        return new ServiceResult<>(null, payrollRunType);
    }

    public static ServiceResult<TypeEntity> DeleteFail() {
        return new ServiceResult<>(PayrollRunTypeNotificationFactory.DeletePayrollRunTypeFail(), null);
    }

    public static ServiceResult<List<TypeEntity>> FetchNull() {
        return new ServiceResult<>(PayrollRunTypeNotificationFactory.FetchNull(), null);
    }

    public static ServiceResult<List<TypeEntity>> FetchResult(List<TypeEntity> payrollRunTypes) {
        return new ServiceResult<>(null, payrollRunTypes);
    }

}
