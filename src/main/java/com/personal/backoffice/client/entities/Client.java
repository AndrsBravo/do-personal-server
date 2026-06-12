package com.personal.backoffice.client.entities;

import com.personal.backoffice.country.entities.Country;
import com.personal.shared.entities.BaseEntity;
import com.personal.shared.entities.TypeEntityBase;

public class Client extends BaseEntity {

    private TypeEntityBase clientType;
    private Country country;

    public Client() {
        super();
    }

    public Client(String id) {
        super(id);
    }

    public TypeEntityBase getClientType() {
        return clientType;
    }

    public void setClientType(TypeEntityBase clientType) {
        this.clientType = clientType;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

}
