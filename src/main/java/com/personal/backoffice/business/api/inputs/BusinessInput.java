package com.personal.backoffice.business.api.inputs;

import com.personal.backoffice.business.entities.Business;
import com.personal.backoffice.client.entities.Client;
import com.personal.backoffice.country.entities.Country;
import com.personal.shared.inputs.Input;

public class BusinessInput extends Input {

    private String clientId;
    private String countryId;
    private String name;

    public BusinessInput() {
        super();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public Business getBusiness() {
        var business = this.id == null || this.id.isEmpty() ? new Business() : new Business(this.id);
        var client = this.clientId == null || this.clientId.isEmpty() ? new Client() : new Client(this.clientId);
        business.setClient(client);
        var country = this.countryId == null || this.countryId.isEmpty() ? new Country() : new Country(this.countryId);
        business.setCountry(country);
        business.setName(this.name);
        business.setCreatedBy(sessionUser);
        return business;
    }
}
