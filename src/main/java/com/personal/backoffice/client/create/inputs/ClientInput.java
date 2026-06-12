package com.personal.backoffice.client.create.inputs;

import com.personal.backoffice.client.entities.Client;
import com.personal.backoffice.country.entities.Country;
import com.personal.shared.entities.TypeEntityBase;
import com.personal.shared.inputs.Input;

public class ClientInput extends Input {

    private String clientTypeId;
    private String countryId;

    public ClientInput() {
        super();
    }

    public void setClientTypeId(String clientTypeId) {
        this.clientTypeId = clientTypeId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public Client getClient() {
        //System.out.println("client_type " + this.clientTypeId);
        var client = this.id == null || this.id.isEmpty() ? new Client() : new Client(this.id);
        var clientType = this.clientTypeId == null || this.clientTypeId.isEmpty() ? new TypeEntityBase() : new TypeEntityBase(this.clientTypeId);
        client.setClientType(clientType);
        var country = this.countryId == null || this.countryId.isEmpty() ? new Country() : new Country(this.countryId);
        client.setCountry(country);
        client.setCreatedBy(sessionUser);
        return client;
    }
}
