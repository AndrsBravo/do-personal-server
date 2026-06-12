package com.personal.backoffice.commercial.plan.entities;

import java.util.List;

import com.personal.backoffice.commercial.plandetail.entities.CommercialPlanDetail;
import com.personal.shared.entities.ShortEntity;

public class CommercialPlan extends ShortEntity {

    private String plan;
    private String title;
    private String description;
    private List<CommercialPlanDetail> details;

    public CommercialPlan() {
        super();
    }

    public CommercialPlan(String id) {
        super(id);
    }

    public List<CommercialPlanDetail> getDetails() {
        return details;
    }

    public void setDetails(List<CommercialPlanDetail> details) {
        this.details = details;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
