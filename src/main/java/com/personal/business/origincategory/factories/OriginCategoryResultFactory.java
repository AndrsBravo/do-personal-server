package com.personal.business.origincategory.factories;

import java.util.List;

import com.personal.business.origincategory.entities.OriginCategory;
import com.personal.business.origincategory.notifications.OriginCategoryNotificationFactory;
import com.personal.shared.services.ServiceResult;

public class OriginCategoryResultFactory {

    public static ServiceResult<OriginCategory> CreateFail() {
        return new ServiceResult<>(OriginCategoryNotificationFactory.CreateOriginCategoryFail(), null);
    }

    public static ServiceResult<OriginCategory> CreateSuccess(OriginCategory originCategory) {
        return new ServiceResult<>(null, originCategory);
    }

    public static ServiceResult<OriginCategory> UpdateFail() {
        return new ServiceResult<>(OriginCategoryNotificationFactory.UpdateOriginCategoryFail(), null);
    }

    public static ServiceResult<OriginCategory> UpdateSuccess(OriginCategory originCategory) {
        return new ServiceResult<>(null, originCategory);
    }

    public static ServiceResult<OriginCategory> DeleteSuccess(OriginCategory originCategory) {
        return new ServiceResult<>(null, originCategory);
    }

    public static ServiceResult<OriginCategory> DeleteFail() {
        return new ServiceResult<>(OriginCategoryNotificationFactory.DeleteOriginCategoryFail(), null);
    }

    public static ServiceResult<List<OriginCategory>> FetchNull() {
        return new ServiceResult<>(OriginCategoryNotificationFactory.FetchNull(), null);
    }

    public static ServiceResult<List<OriginCategory>> FetchResult(List<OriginCategory> originCategory) {
        return new ServiceResult<>(null, originCategory);
    }

}
