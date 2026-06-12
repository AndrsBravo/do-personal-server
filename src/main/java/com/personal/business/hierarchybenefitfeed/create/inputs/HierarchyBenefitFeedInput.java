package com.personal.business.hierarchybenefitfeed.create.inputs;

import java.time.LocalDateTime;

import com.personal.business.benefit.entities.Benefit;
import com.personal.business.hierarchy.entities.Hierarchy;
import com.personal.business.hierarchybenefitfeed.entities.HierarchyBenefitFeed;
import com.personal.business.temporalfrequency.entities.TemporalFrequency;
import com.personal.shared.inputs.BusinessInputBase;

public class HierarchyBenefitFeedInput extends BusinessInputBase {

    private String benefitId;
    private String hierarchyId;
    private String temporalFrequencyId;
    private Double amount;
    private LocalDateTime started_at;
    private LocalDateTime ended_at;

    public HierarchyBenefitFeedInput() {
        super();
    }

    public void setBenefitId(String benefitId) {
        this.benefitId = benefitId;
    }

    public void setHierarchyId(String hierarchyId) {
        this.hierarchyId = hierarchyId;
    }

    public HierarchyBenefitFeed getHierarchyBenefitFeed() {
        var hierarchyBenefitFeed = this.id == null || this.id.isEmpty() ? new HierarchyBenefitFeed() : new HierarchyBenefitFeed(this.id);
        hierarchyBenefitFeed.setBenefit(new Benefit(benefitId));
        hierarchyBenefitFeed.setHierarchy(new Hierarchy(hierarchyId));
        hierarchyBenefitFeed.setTemporalFrequency(new TemporalFrequency(temporalFrequencyId));
        hierarchyBenefitFeed.setAmount(amount);
        hierarchyBenefitFeed.setStartedAt(started_at);
        hierarchyBenefitFeed.setEndedAt(ended_at);
        hierarchyBenefitFeed.setBusiness(this.getBusiness());
        hierarchyBenefitFeed.setCreatedBy(sessionUser);
        return hierarchyBenefitFeed;
    }
}
