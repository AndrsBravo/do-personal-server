package com.personal.management.temporalfrequency.factories;

import java.util.List;

import com.personal.management.temporalfrequency.entities.TemporalFrequency;
import com.personal.management.temporalfrequency.notifications.TemporalFrequencyNotificationFactory;
import com.personal.shared.services.entities.ServiceResult;

public class TemporalFrequencyResultFactory {

    public static ServiceResult<TemporalFrequency> CreateFail() {
        return new ServiceResult<>(TemporalFrequencyNotificationFactory.CreateTemporalFrequencyFail(), null);
    }

    public static ServiceResult<TemporalFrequency> CreateSuccess(TemporalFrequency temporalFrequency) {
        return new ServiceResult<>(null, temporalFrequency);
    }

    public static ServiceResult<TemporalFrequency> UpdateFail() {
        return new ServiceResult<>(TemporalFrequencyNotificationFactory.UpdateTemporalFrequencyFail(), null);
    }

    public static ServiceResult<TemporalFrequency> UpdateSuccess(TemporalFrequency temporalFrequency) {
        return new ServiceResult<>(null, temporalFrequency);
    }

    public static ServiceResult<TemporalFrequency> DeleteSuccess(TemporalFrequency temporalFrequency) {
        return new ServiceResult<>(null, temporalFrequency);
    }

    public static ServiceResult<TemporalFrequency> DeleteFail() {
        return new ServiceResult<>(TemporalFrequencyNotificationFactory.DeleteTemporalFrequencyFail(), null);
    }

    public static ServiceResult<List<TemporalFrequency>> FetchNull() {
        return new ServiceResult<>(TemporalFrequencyNotificationFactory.FetchNull(), null);
    }

    public static ServiceResult<List<TemporalFrequency>> FetchResult(List<TemporalFrequency> temporalFrequency) {
        return new ServiceResult<>(null, temporalFrequency);
    }

}
