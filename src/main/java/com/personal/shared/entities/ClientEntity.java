package com.personal.shared.entities;

import com.personal.backoffice.client.entities.Client;

public abstract class ClientEntity extends BaseEntity {

    private Client client;

    public ClientEntity() {
        super();
    }

    public ClientEntity(String id) {
        super(id);
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}
