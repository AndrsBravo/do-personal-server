package com.personal.business.deduction.factories;

import java.util.List;

import com.personal.business.deduction.entities.Deduction;
import com.personal.business.deduction.notifications.DeductionNotificationFactory;
import com.personal.shared.services.ServiceResult;

public class DeductionResultFactory {

    public static ServiceResult<Deduction> CreateFail() {
        return new ServiceResult<>(DeductionNotificationFactory.CreateDeductionFail(), null);
    }

    public static ServiceResult<Deduction> CreateSuccess(Deduction deduction) {
        return new ServiceResult<>(null, deduction);
    }

    public static ServiceResult<Deduction> UpdateFail() {
        return new ServiceResult<>(DeductionNotificationFactory.UpdateDeductionFail(), null);
    }

    public static ServiceResult<Deduction> UpdateSuccess(Deduction deduction) {
        return new ServiceResult<>(null, deduction);
    }

    public static ServiceResult<Deduction> DeleteSuccess(Deduction deduction) {
        return new ServiceResult<>(null, deduction);
    }

    public static ServiceResult<Deduction> DeleteFail() {
        return new ServiceResult<>(DeductionNotificationFactory.DeleteDeductionFail(), null);
    }

    public static ServiceResult<List<Deduction>> FetchNull() {
        return new ServiceResult<>(DeductionNotificationFactory.FetchNull(), null);
    }

    public static ServiceResult<List<Deduction>> FetchResult(List<Deduction> deduction) {
        return new ServiceResult<>(null, deduction);
    }

}
