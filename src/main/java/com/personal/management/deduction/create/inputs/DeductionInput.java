package com.personal.management.deduction.create.inputs;

import com.personal.backoffice.shared.inputs.CountryInputBase;
import com.personal.management.deduction.entities.Deduction;

public class DeductionInput extends CountryInputBase {

    private String title;
    private String deduction;
    private String description;

    public DeductionInput() {
        super();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDeduction(String relation) {
        this.deduction = relation;
    }

    public Deduction getDeduction() {
        var _deduction = this.id == null || this.id.isEmpty() ? new Deduction() : new Deduction(this.id);
        _deduction.setTitle(title);
        _deduction.setDeduction(deduction);
        _deduction.setDescription(description);
        _deduction.setCreatedBy(sessionUser);
        return _deduction;
    }
}
