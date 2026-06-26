package com.personal.management.benefit.create.inputs;

import com.personal.management.benefit.entities.Benefit;
import com.personal.management.shared.inputs.CountryInputBase;

public class BenefitInput extends CountryInputBase {

    private String title;
    private String benefit;
    private String description;

    public BenefitInput() {
        super();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBenefit(String benefit) {
        this.benefit = benefit;
    }

    public Benefit getBenefit() {
        var _benefit = this.id == null || this.id.isEmpty() ? new Benefit() : new Benefit(this.id);
        _benefit.setTitle(title);
        _benefit.setBenefit(benefit);
        _benefit.setDescription(description);
        _benefit.setCreatedBy(sessionUser);
        _benefit.setCountry(this.getCountry());
        return _benefit;
    }
}
