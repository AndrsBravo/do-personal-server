package com.personal.backoffice.business.factories;

import java.util.List;

import com.personal.backoffice.business.entities.Business;
import com.personal.backoffice.business.notifications.BusinessNotificationFactory;
import com.personal.shared.services.entities.ServiceResult;

public class BusinessResultFactory {

    public static ServiceResult<Business> CreateFail() {
        return new ServiceResult<>(BusinessNotificationFactory.CreateBusinessFail(), null);
    }

    public static ServiceResult<Business> CreateSuccess(Business business) {
        return new ServiceResult<>(null, business);
    }

    public static ServiceResult<Business> UpdateFail() {
        return new ServiceResult<>(BusinessNotificationFactory.UpdateBusinessFail(), null);
    }

    public static ServiceResult<Business> UpdateSuccess(Business business) {
        return new ServiceResult<>(null, business);
    }

    public static ServiceResult<Business> DeleteSuccess(Business business) {
        return new ServiceResult<>(null, business);
    }

    public static ServiceResult<Business> DeleteFail() {
        return new ServiceResult<>(BusinessNotificationFactory.DeleteBusinessFail(), null);
    }

    public static ServiceResult<List<Business>> FetchNull() {
        return new ServiceResult<>(BusinessNotificationFactory.FetchNull(), null);
    }

    public static ServiceResult<List<Business>> FetchResult(List<Business> business) {
        return new ServiceResult<>(null, business);
    }

}
