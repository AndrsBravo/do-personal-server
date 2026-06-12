package com.personal.backoffice.commercial.plandetail.entities;

import com.personal.backoffice.commercial.entity.entities.CommercialEntity;
import com.personal.backoffice.commercial.plan.entities.CommercialPlan;
import com.personal.shared.entities.ShortEntity;

public class CommercialPlanDetail extends ShortEntity {

    private Integer quantity;
    private CommercialPlan plan;
    private CommercialEntity entity;

    public CommercialPlanDetail() {
        super();
    }

    public CommercialPlanDetail(String id) {
        super(id);
    }

    public CommercialPlan getPlan() {
        return plan;
    }

    public void setPlan(CommercialPlan plan) {
        this.plan = plan;
    }

    public CommercialEntity getEntity() {
        return entity;
    }

    public void setEntity(CommercialEntity entity) {
        this.entity = entity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
