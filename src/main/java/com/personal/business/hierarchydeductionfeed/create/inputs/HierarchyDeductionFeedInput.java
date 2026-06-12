package com.personal.business.hierarchydeductionfeed.create.inputs;

import java.time.LocalDateTime;

import com.personal.business.deduction.entities.Deduction;
import com.personal.business.hierarchy.entities.Hierarchy;
import com.personal.business.hierarchydeductionfeed.entities.HierarchyDeductionFeed;
import com.personal.business.temporalfrequency.entities.TemporalFrequency;
import com.personal.shared.inputs.BusinessInputBase;

public class HierarchyDeductionFeedInput extends BusinessInputBase {

    private String deductionId;
    private String hierarchyId;
    private String temporalFrequencyId;
    private Double amount;
    private LocalDateTime started_at;
    private LocalDateTime ended_at;

    public HierarchyDeductionFeedInput() {
        super();
    }

    public void setDeductionId(String deductionId) {
        this.deductionId = deductionId;
    }

    public void setHierarchyId(String hierarchyId) {
        this.hierarchyId = hierarchyId;
    }

    public HierarchyDeductionFeed getHierarchyDeductionFeed() {
        var hierarchyDeductionFeed = this.id == null || this.id.isEmpty() ? new HierarchyDeductionFeed() : new HierarchyDeductionFeed(this.id);
        hierarchyDeductionFeed.setDeduction(new Deduction(deductionId));
        hierarchyDeductionFeed.setHierarchy(new Hierarchy(hierarchyId));
        hierarchyDeductionFeed.setTemporalFrequency(new TemporalFrequency(temporalFrequencyId));
        hierarchyDeductionFeed.setAmount(amount);
        hierarchyDeductionFeed.setStartedAt(started_at);
        hierarchyDeductionFeed.setEndedAt(ended_at);
        hierarchyDeductionFeed.setBusiness(this.getBusiness());
        hierarchyDeductionFeed.setCreatedBy(sessionUser);
        return hierarchyDeductionFeed;
    }
}
