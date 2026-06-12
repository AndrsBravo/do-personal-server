package com.personal.business.hierarchydeductionfeed.entities;

import java.time.LocalDateTime;

import com.personal.business.deduction.entities.Deduction;
import com.personal.business.hierarchy.entities.Hierarchy;
import com.personal.business.temporalfrequency.entities.TemporalFrequency;
import com.personal.shared.entities.BusinessEntity;

public class HierarchyDeductionFeed extends BusinessEntity {

    private Deduction deduction;
    private Hierarchy hierarchy;
    private TemporalFrequency temporalFrequency;
    private Double amount;
    private LocalDateTime started_at;
    private LocalDateTime ended_at;

    public HierarchyDeductionFeed() {
        super();
    }

    public HierarchyDeductionFeed(String id) {
        super(id);
    }

    public Deduction getDeduction() {
        return deduction;
    }

    public void setDeduction(Deduction deduction) {
        this.deduction = deduction;
    }

    public Hierarchy getHierarchy() {
        return hierarchy;
    }

    public void setHierarchy(Hierarchy hierarchy) {
        this.hierarchy = hierarchy;
    }

    public TemporalFrequency getTemporalFrequency() {
        return temporalFrequency;
    }

    public void setTemporalFrequency(TemporalFrequency temporalFrequency) {
        this.temporalFrequency = temporalFrequency;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getStartedAt() {
        return started_at;
    }

    public LocalDateTime getEndedAt() {
        return ended_at;
    }

    public void setStartedAt(LocalDateTime started_at) {
        this.started_at = started_at;
    }

    public void setEndedAt(LocalDateTime ended_at) {
        this.ended_at = ended_at;
    }
}
