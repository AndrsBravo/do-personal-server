package com.personal.backoffice.commercial.entity.factories;

import java.util.List;

import com.personal.backoffice.commercial.entity.entities.CommercialEntity;
import com.personal.backoffice.commercial.entity.notifications.CommercialEntityNotificationFactory;
import com.personal.shared.services.entities.ServiceResult;

public class CommercialEntityResultFactory {

    public static ServiceResult<CommercialEntity> CreateFail() {
        return new ServiceResult<>(CommercialEntityNotificationFactory.CreateCommercialEntityFail(), null);
    }

    public static ServiceResult<CommercialEntity> CreateSuccess(CommercialEntity commercialEntity) {
        return new ServiceResult<>(null, commercialEntity);
    }

    public static ServiceResult<CommercialEntity> UpdateFail() {
        return new ServiceResult<>(CommercialEntityNotificationFactory.UpdateCommercialEntityFail(), null);
    }

    public static ServiceResult<CommercialEntity> UpdateSuccess(CommercialEntity commercialEntity) {
        return new ServiceResult<>(null, commercialEntity);
    }

    public static ServiceResult<CommercialEntity> DeleteSuccess(CommercialEntity commercialEntity) {
        return new ServiceResult<>(null, commercialEntity);
    }

    public static ServiceResult<CommercialEntity> DeleteFail() {
        return new ServiceResult<>(CommercialEntityNotificationFactory.DeleteCommercialEntityFail(), null);
    }

    public static ServiceResult<List<CommercialEntity>> FetchNull() {
        return new ServiceResult<>(CommercialEntityNotificationFactory.FetchNull(), null);
    }

    public static ServiceResult<List<CommercialEntity>> FetchResult(List<CommercialEntity> commercialEntity) {
        return new ServiceResult<>(null, commercialEntity);
    }

}
