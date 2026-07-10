package com.personal.backoffice.client.factories;

import java.util.List;

import com.personal.backoffice.client.entities.Client;
import com.personal.backoffice.client.entities.ClientCommercialPlan;
import com.personal.backoffice.client.notifications.ClientNotificationFactory;
import com.personal.shared.services.entities.ServiceResult;

public class ClientResultFactory {

    public static ServiceResult<Client> CreateFail() {
        return new ServiceResult<>(ClientNotificationFactory.CreateClientFail(), null);
    }

    public static ServiceResult<Client> CreateSuccess(Client client) {
        return new ServiceResult<>(null, client);
    }

    public static ServiceResult<Client> UpdateFail() {
        return new ServiceResult<>(ClientNotificationFactory.UpdateClientFail(), null);
    }

    public static ServiceResult<Client> UpdateSuccess(Client client) {
        return new ServiceResult<>(null, client);
    }

    public static ServiceResult<Client> DeleteSuccess(Client client) {
        return new ServiceResult<>(null, client);
    }

    public static ServiceResult<Client> DeleteFail() {
        return new ServiceResult<>(ClientNotificationFactory.DeleteClientFail(), null);
    }

    public static ServiceResult<List<Client>> FetchNull() {
        return new ServiceResult<>(ClientNotificationFactory.FetchNull(), null);
    }

    public static ServiceResult<List<Client>> FetchResult(List<Client> clients) {
        return new ServiceResult<>(null, clients);
    }

    public static ServiceResult<ClientCommercialPlan> AddCommercialPlanSuccess(ClientCommercialPlan client) {
        return new ServiceResult<>(null, client);
    }

    public static ServiceResult<ClientCommercialPlan> AddCommercialPlanFail() {
        return new ServiceResult<>(ClientNotificationFactory.AddCommercialPlanFail(), null);
    }

    public static ServiceResult<List<ClientCommercialPlan>> FilterCommercialPlanSuccess(List<ClientCommercialPlan> client) {
        return new ServiceResult<>(null, client);
    }

    public static ServiceResult<List<ClientCommercialPlan>> FilterCommercialPlanFail() {
        return new ServiceResult<>(ClientNotificationFactory.FilterCommercialPlanFail(), null);
    }

}
