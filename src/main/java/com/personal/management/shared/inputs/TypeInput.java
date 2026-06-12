package com.personal.management.shared.inputs;

import com.personal.management.country.entities.Country;
import com.personal.management.shared.entities.TypeEntity;
import com.personal.shared.inputs.BaseTypeInput;

public class TypeInput extends BaseTypeInput {

    private String countryId;

    public String getCountryId() {
        return countryId;
    }

    @Override
    public TypeEntity getType() {
        var userType = this.id == null || this.id.isEmpty() ? new TypeEntity() : new TypeEntity(this.id);
        var country = new Country(this.countryId);
        userType.setType(this.type);
        userType.setTitle(this.title);
        userType.setDescription(this.description);
        userType.setCountry(country);
        userType.setCreatedBy(this.sessionUser);
        return userType;
    }

}
