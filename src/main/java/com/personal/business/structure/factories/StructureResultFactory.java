package com.personal.business.structure.factories;

import java.util.List;

import com.personal.business.structure.entities.Structure;
import com.personal.business.structure.notifications.StructureNotificationFactory;
import com.personal.shared.services.entities.ServiceResult;

public class StructureResultFactory {

    public static ServiceResult<Structure> CreateFail() {
        return new ServiceResult<>(StructureNotificationFactory.CreateStructureFail(), null);
    }

    public static ServiceResult<Structure> CreateSuccess(Structure structure) {
        return new ServiceResult<>(null, structure);
    }

    public static ServiceResult<Structure> UpdateFail() {
        return new ServiceResult<>(StructureNotificationFactory.UpdateStructureFail(), null);
    }

    public static ServiceResult<Structure> UpdateSuccess(Structure structure) {
        return new ServiceResult<>(null, structure);
    }

    public static ServiceResult<Structure> DeleteSuccess(Structure structure) {
        return new ServiceResult<>(null, structure);
    }

    public static ServiceResult<Structure> DeleteFail() {
        return new ServiceResult<>(StructureNotificationFactory.DeleteStructureFail(), null);
    }

    public static ServiceResult<List<Structure>> FetchNull() {
        return new ServiceResult<>(StructureNotificationFactory.FetchNull(), null);
    }

    public static ServiceResult<List<Structure>> FetchResult(List<Structure> structure) {
        return new ServiceResult<>(null, structure);
    }

}
