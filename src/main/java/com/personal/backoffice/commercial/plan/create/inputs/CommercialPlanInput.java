package com.personal.backoffice.commercial.plan.create.inputs;

import com.personal.backoffice.commercial.plan.entities.CommercialPlan;
import com.personal.shared.inputs.Input;

public class CommercialPlanInput extends Input {

    private String title;
    private String entity;
    private String description;

    public CommercialPlanInput() {
        super();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPlan(String relation) {
        this.entity = relation;
    }

    public CommercialPlan getCommercialPlan() {
        var commercialPlan = this.id == null || this.id.isEmpty() ? new CommercialPlan() : new CommercialPlan(this.id);
        commercialPlan.setTitle(title);
        commercialPlan.setPlan(entity);
        commercialPlan.setDescription(description);
        commercialPlan.setCreatedBy(sessionUser);
        return commercialPlan;
    }
}
