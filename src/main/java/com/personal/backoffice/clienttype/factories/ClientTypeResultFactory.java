package com.personal.backoffice.clienttype.factories;

import java.util.List;

import com.personal.backoffice.clienttype.notifications.ClientTypeNotificationFactory;
import com.personal.shared.entities.TypeEntityBase;
import com.personal.shared.services.entities.ServiceResult;

public class ClientTypeResultFactory {

    public static ServiceResult<TypeEntityBase> CreateFail() {
        return new ServiceResult<>(ClientTypeNotificationFactory.CreateClientTypeFail(), null);
    }

    public static ServiceResult<TypeEntityBase> CreateSuccess(TypeEntityBase clientType) {
        return new ServiceResult<>(null, clientType);
    }

    public static ServiceResult<TypeEntityBase> UpdateFail() {
        return new ServiceResult<>(ClientTypeNotificationFactory.UpdateClientTypeFail(), null);
    }

    public static ServiceResult<TypeEntityBase> UpdateSuccess(TypeEntityBase clientType) {
        return new ServiceResult<>(null, clientType);
    }

    public static ServiceResult<TypeEntityBase> DeleteSuccess(TypeEntityBase clientType) {
        return new ServiceResult<>(null, clientType);
    }

    public static ServiceResult<TypeEntityBase> DeleteFail() {
        return new ServiceResult<>(ClientTypeNotificationFactory.DeleteClientTypeFail(), null);
    }

    public static ServiceResult<List<TypeEntityBase>> FetchNull() {
        return new ServiceResult<>(ClientTypeNotificationFactory.FetchNull(), null);
    }

    public static ServiceResult<List<TypeEntityBase>> FetchResult(List<TypeEntityBase> clientTypes) {
        return new ServiceResult<>(null, clientTypes);
    }

}
