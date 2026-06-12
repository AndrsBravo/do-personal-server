package com.personal.backoffice.commercial.plandetail.create.inputs;

import com.personal.backoffice.commercial.entity.entities.CommercialEntity;
import com.personal.backoffice.commercial.plan.entities.CommercialPlan;
import com.personal.backoffice.commercial.plandetail.entities.CommercialPlanDetail;
import com.personal.shared.inputs.Input;

public class CommercialPlanDetailInput extends Input {

    private String entityId;
    private String planId;
    private Integer quantity;

    public CommercialPlanDetailInput() {
        super();
    }

    public void setEntityId(String title) {
        this.entityId = title;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setPlanId(String plan) {
        this.planId = plan;
    }

    public CommercialPlanDetail getCommercialPlanDetail() {
        var commercialPlan = this.id == null || this.id.isEmpty() ? new CommercialPlanDetail() : new CommercialPlanDetail(this.id);
        var plan = this.planId == null || this.planId.isEmpty() ? new CommercialPlan() : new CommercialPlan(this.planId);
        var entity = this.entityId == null || this.entityId.isEmpty() ? new CommercialEntity() : new CommercialEntity(this.entityId);

        commercialPlan.setPlan(plan);
        commercialPlan.setEntity(entity);
        commercialPlan.setQuantity(quantity);
        commercialPlan.setCreatedBy(sessionUser);
        return commercialPlan;
    }
}
