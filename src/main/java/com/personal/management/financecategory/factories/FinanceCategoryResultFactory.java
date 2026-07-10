package com.personal.management.financecategory.factories;

import java.util.List;

import com.personal.management.financecategory.entities.FinanceCategory;
import com.personal.management.financecategory.notifications.FinanceCategoryNotificationFactory;
import com.personal.shared.services.entities.ServiceResult;

public class FinanceCategoryResultFactory {

    public static ServiceResult<FinanceCategory> CreateFail() {
        return new ServiceResult<>(FinanceCategoryNotificationFactory.CreateFinanceCategoryFail(), null);
    }

    public static ServiceResult<FinanceCategory> CreateSuccess(FinanceCategory financeCategory) {
        return new ServiceResult<>(null, financeCategory);
    }

    public static ServiceResult<FinanceCategory> UpdateFail() {
        return new ServiceResult<>(FinanceCategoryNotificationFactory.UpdateFinanceCategoryFail(), null);
    }

    public static ServiceResult<FinanceCategory> UpdateSuccess(FinanceCategory financeCategory) {
        return new ServiceResult<>(null, financeCategory);
    }

    public static ServiceResult<FinanceCategory> DeleteSuccess(FinanceCategory financeCategory) {
        return new ServiceResult<>(null, financeCategory);
    }

    public static ServiceResult<FinanceCategory> DeleteFail() {
        return new ServiceResult<>(FinanceCategoryNotificationFactory.DeleteFinanceCategoryFail(), null);
    }

    public static ServiceResult<List<FinanceCategory>> FetchNull() {
        return new ServiceResult<>(FinanceCategoryNotificationFactory.FetchNull(), null);
    }

    public static ServiceResult<List<FinanceCategory>> FetchResult(List<FinanceCategory> financeCategory) {
        return new ServiceResult<>(null, financeCategory);
    }

}
