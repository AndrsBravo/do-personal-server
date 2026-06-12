package com.personal.business.benefit.create.inputs;

import com.personal.business.benefit.entities.Benefit;
import com.personal.shared.inputs.Input;

public class BenefitInput extends Input {

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

    public void setBenefit(String relation) {
        this.benefit = relation;
    }

    public Benefit getBenefit() {
        var _benefit = this.id == null || this.id.isEmpty() ? new Benefit() : new Benefit(this.id);
        _benefit.setTitle(title);
        _benefit.setBenefit(benefit);
        _benefit.setDescription(description);
        _benefit.setCreatedBy(sessionUser);
        return _benefit;
    }
}
